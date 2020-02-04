import { Component, OnInit } from '@angular/core';
import { Tweet } from '../tweet';
import { ApiService } from '../api-service.service';
import { Observable } from 'rxjs';
import { HttpResponse } from '@angular/common/http';

@Component({
  selector: 'app-tweet',
  templateUrl: './tweet.component.html',
  styleUrls: ['./tweet.component.css']
})
export class TweetComponent implements OnInit {
  apiURL = 'http://localhost:8083';
  

  constructor(
    public restApi: ApiService
  ) { }

  ngOnInit() {
    this.getTweet(this.apiURL);
  }
  getTweet(apiURL): Observable<HttpResponse<Timeline>> {
    this.restApi.getTweet(apiURL);
  }
}
