import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Tweet } from './tweet';

@Injectable({
  providedIn: 'root'
})
export class ApiTwitterService {
  constructor(private http: HttpClient) { }

}

