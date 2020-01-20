import { InMemoryDbService } from 'angular-in-memory-web-api';
import { Tweet } from './tweet';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class InMemoryDataService implements InMemoryDbService {
  createDb() {
    const tweets = [
      { id: 1, author: 'someone', message: 'Nice', date: 15},
      { id: 2, author: 'sometwo', message: 'Not Nice', date: 16},
      { id: 3, author: 'somethree', message: 'Really Nice', date: 17},
    ];
    return {tweets};
  }

  genId(tweets: Tweet[]): number {
    return tweets.length > 0 ? Math.max(...tweets.map(hero => hero.id)) + 1 : 11;
  }
}