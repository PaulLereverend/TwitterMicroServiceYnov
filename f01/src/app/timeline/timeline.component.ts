import { Component, OnInit } from '@angular/core';
import { ApiService } from '../api-service.service';
import { Observable } from 'rxjs';
import { HttpResponse } from '@angular/common/http';
import { TimeLine } from '../timeLine';
import { Tweet } from '../tweet';

@Component({
  selector: 'app-timeline',
  templateUrl: './timeline.component.html',
  styleUrls: ['./timeline.component.css']
})
export class TimelineComponent implements OnInit {
  apiURL = 'b3'; //http://localhost:8083
  public tweet = {
    user: 'W',
    text: '',
    date: new Date()
  };
  timeline = [
    {
      "date": "Tue Feb 04 07:15:52 UTC 2020",
      "text": "test",
      "user": "PyresRobert"
    },
    {
      "date": "Tue Feb 04 04:27:51 UTC 2020",
      "text": "Big WIN for us in Iowa tonight. Thank you!",
      "user": "realDonaldTrump"
    },
    {
      "date": "Tue Feb 04 04:23:21 UTC 2020",
      "text": "RT @SaraCarterDC: #EXCLUSIVE\n\nGOP Investigation:Thousands Of Obama Admin Docs Under Review Regarding Ukraine White House Meetings \n\nRead my…",
      "user": "realDonaldTrump"
    }]

    constructor(
    public restApi: ApiService
  ) {}

  ngOnInit() {
    this.getTimeline(this.apiURL);
    this.sliceTimeline(this.timeline);
  }
  getTimeline(apiURL) {}

  sliceTimeline(timeline) {
    timeline.forEach(element => {
      this.tweet = element;
      console.log(this.tweet)
    });
  }
}
