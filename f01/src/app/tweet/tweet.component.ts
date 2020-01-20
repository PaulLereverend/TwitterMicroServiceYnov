import { Component, OnInit } from '@angular/core';
import { Tweet } from '../tweet';

@Component({
  selector: 'app-tweet',
  templateUrl: './tweet.component.html',
  styleUrls: ['./tweet.component.css']
})
export class TweetComponent implements OnInit {
  tweet: Tweet = {
    id: 1,
    author: 'Windstorm',
    message: 'wlh',
    date: new Date()
  };
  constructor() { }

  ngOnInit() {
    
  }

}
