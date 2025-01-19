import { bootstrapApplication } from '@angular/platform-browser';
import { AppComponent } from './app/app.component';

import { MsalGuardConfiguration } from '@azure/msal-angular';


import { InteractionType } from '@azure/msal-browser';
import { appConfig } from './app/app.config';

export function MSALGuardConfigFactory(): MsalGuardConfiguration {
  return {
    interactionType: InteractionType.Redirect,
    authRequest: {
      scopes: [],
    },
  };
}

bootstrapApplication(AppComponent, appConfig).catch((err) =>
  console.error(err)
);
