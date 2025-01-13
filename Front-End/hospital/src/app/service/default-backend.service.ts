import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class DefaultBackendService {

  private readonly apiUrl = 'https://15pe79tui0.execute-api.us-east-1.amazonaws.com/';
  private readonly httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json',
    }),
  };

  constructor(private readonly http: HttpClient) {}

  public consumirBackend() {
    const body = {
      key: 'Hola mundo'
    };

    return this.http.post(this.apiUrl, body, this.httpOptions);
  }
}
