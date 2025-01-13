
import { RouterLink, RouterOutlet } from '@angular/router';
import { Component, OnInit, Inject, OnDestroy } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Subject } from 'rxjs';
import { filter, takeUntil } from 'rxjs/operators';
import {AuthenticationResult,InteractionStatus,PopupRequest,RedirectRequest,EventMessage,EventType} from '@azure/msal-browser';
import {MsalService,MsalModule,MsalBroadcastService,MSAL_GUARD_CONFIG,MsalGuardConfiguration} from '@azure/msal-angular';
import { MatMenuModule } from '@angular/material/menu';
import { MatButtonModule } from '@angular/material/button';
import { MatToolbarModule } from '@angular/material/toolbar';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet,CommonModule,MsalModule,RouterLink,MatToolbarModule,MatButtonModule,MatMenuModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent  implements  OnInit, OnDestroy {
  title = 'hospital';

  isIframe = false;
  loginDisplay = false;
  private readonly _destroying$ = new Subject<void>();

  constructor(
    @Inject(MSAL_GUARD_CONFIG) private readonly msalGuardConfig: MsalGuardConfiguration,
    private readonly authService: MsalService,
    private readonly msalBroadcastService: MsalBroadcastService
  ) {}

  ngOnInit(): void {
    this.authService.handleRedirectObservable().subscribe();
    this.isIframe = window !== window.parent && !window.opener; // Remove this line to use Angular Universal

    this.setLoginDisplay();

    this.authService.instance.enableAccountStorageEvents(); // Optional - This will enable ACCOUNT_ADDED and ACCOUNT_REMOVED events emitted when a user logs in or out of another tab or window
    this.msalBroadcastService.msalSubject$
      .pipe(
        filter(
          (msg: EventMessage) =>
            msg.eventType === EventType.ACCOUNT_ADDED ||
            msg.eventType === EventType.ACCOUNT_REMOVED
        )
      )
      .subscribe((result: EventMessage) => {
        if (this.authService.instance.getAllAccounts().length === 0) {
          window.location.pathname = '/';
        } else {
          this.setLoginDisplay();
        }
      });

    this.msalBroadcastService.inProgress$
      .pipe(
        filter(
          (status: InteractionStatus) => status === InteractionStatus.None
        ),
        takeUntil(this._destroying$)
      )
      .subscribe(() => {
        this.setLoginDisplay();
        this.checkAndSetActiveAccount();
      });
  }

  setLoginDisplay() {
    this.loginDisplay = this.authService.instance.getAllAccounts().length > 0;
  }

  checkAndSetActiveAccount() {
    /**
     * If no active account set but there are accounts signed in, sets first account to active account
     * To use active account set here, subscribe to inProgress$ first in your component
     * Note: Basic usage demonstrated. Your app may require more complicated account selection logic
     */
    let activeAccount = this.authService.instance.getActiveAccount();

    if (
      !activeAccount &&
      this.authService.instance.getAllAccounts().length > 0
    ) {
      let accounts = this.authService.instance.getAllAccounts();
      this.authService.instance.setActiveAccount(accounts[0]);
    }
  }

  loginRedirect() {
    if (this.msalGuardConfig.authRequest) {
      this.authService.loginRedirect({
        ...this.msalGuardConfig.authRequest,
      } as RedirectRequest);
    } else {
      this.authService.loginRedirect();
    }
  }

  loginPopup() {
    if (this.msalGuardConfig.authRequest) {
      this.authService
        .loginPopup({ ...this.msalGuardConfig.authRequest } as PopupRequest)
        .subscribe((response: AuthenticationResult) => {
          this.authService.instance.setActiveAccount(response.account);
  
          // Obtener y guardar el token de acceso
          this.authService.acquireTokenSilent({ scopes: ['User.Read'] }).subscribe({
            next: (tokenResponse) => {
              localStorage.setItem('jwt', tokenResponse.idToken); // Guarda el token en el localStorage
              console.log('ID token guardado en localStorage:', tokenResponse.idToken);
            },
            error: (error) => {
              console.error('Error obteniendo el token de acceso:', error);
            },
          });
        });
    } else {
      this.authService
        .loginPopup()
        .subscribe((response: AuthenticationResult) => {
          this.authService.instance.setActiveAccount(response.account);
  
          // Obtener y guardar el token de acceso
          this.authService.acquireTokenSilent({ scopes: ['User.Read'] }).subscribe({
            next: (tokenResponse) => {
              localStorage.setItem('jwt', tokenResponse.accessToken);
              console.log('ID token guardado en localStorage:', tokenResponse.accessToken);
            },
            error: (error) => {
              console.error('Error obteniendo el token de acceso:', error);
            },
          });
        });
    }
  }
  

  logout(popup?: boolean) {
    if (popup) {
      this.authService.logoutPopup({
        mainWindowRedirectUri: '/',
      });
    } else {
      this.authService.logoutRedirect();
    }
  }

  ngOnDestroy(): void {
    this._destroying$.next(undefined);
    this._destroying$.complete();
  }
}
