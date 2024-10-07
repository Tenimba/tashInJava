import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ConnectBackService {
  private baseUrl = 'http://localhost:8080/api';

  constructor(private http: HttpClient) { }

  getHelloMessage(): Observable<string> {
    return this.http.get<string>(`${this.baseUrl}/hello`, { responseType: 'text' as 'json' });
  }
}
