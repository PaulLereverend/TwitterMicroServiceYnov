import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Tweet } from './tweet';

@Injectable({
  providedIn: 'root'
})
export class ApiTwitterService {
  apiURL = 'http://localhost:8083';
  constructor(private http: HttpClient) { }

  getTweets(): Observable<Tweet> {
    return this.http.get<Tweet>(this.apiURL + '/tweet/:id');
  }
}

