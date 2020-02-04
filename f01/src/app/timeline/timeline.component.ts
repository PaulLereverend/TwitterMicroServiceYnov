import { Component, OnInit } from '@angular/core';
import { ApiService } from '../api-service.service';
import { Observable } from 'rxjs';
import { HttpResponse } from '@angular/common/http';
import { TimeLine } from '../timeLine';

@Component({
  selector: 'app-timeline',
  templateUrl: './timeline.component.html',
  styleUrls: ['./timeline.component.css']
})
export class TimelineComponent implements OnInit {
  apiURL = 'http://localhost:8083';
  timeline: TimeLine = {
    
  };

  constructor(
    public restApi: ApiService
  ) { }

  ngOnInit() {
    this.getTimeline(this.apiURL);
  }
  getTimeline(apiURL): Observable<HttpResponse<Timeline>> {
    this.restApi.getTimeline(apiURL);
  }
}
