export const environment = {
    production: false,
    msalConfig: {
      auth: {
        clientId: 'ca8e8e55-b28f-495d-b15d-df4e40406f72',
        authority: 'https://login.microsoftonline.com/common',
      },
    },
    apiConfig: {
      scopes: ['User.Read'],
      uri: 'https://graph.microsoft.com/v1.0/me',
    },
  };