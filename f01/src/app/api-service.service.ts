import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Tweet } from './tweet';


@Injectable({
  providedIn: 'root'
})
export class ApiService {
  constructor(private http: HttpClient) { }

  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json',
    })
  };

  postUser(APIUrl, values) {
    console.log(values);
    console.log(APIUrl);
    return this.http.put(APIUrl, values);
  }

  getTimeline(APIUrl) {
  return this.http.get(APIUrl + '/timeline');
  }
  getTweet(APIUrl): Observable<Tweet> {
    return this.http.get<Tweet>(APIUrl + '/timeline');
    }

}
