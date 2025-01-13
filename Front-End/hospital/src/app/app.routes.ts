import { Routes } from '@angular/router';
import { ProfileComponent } from './profile/profile.component';
import { HomeComponent } from './home/home.component';
import { FailedComponent } from './failed/failed.component';
import { MsalGuard } from '@azure/msal-angular';

export const routes: Routes = [

    {
        path: 'profile',
        component: ProfileComponent,
        canActivate: [MsalGuard],
      },
      {
        path: '',
        component: HomeComponent,
      },
      {
        path: 'login-failed',
        component: FailedComponent,
      },
];
