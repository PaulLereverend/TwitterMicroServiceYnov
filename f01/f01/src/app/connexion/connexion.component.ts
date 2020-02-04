import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms';
import { ApiService } from '../api-service.service';

@Component({
  selector: 'app-connexion',
  templateUrl: './connexion.component.html',
  styleUrls: ['./connexion.component.css']
})
export class ConnexionComponent implements OnInit {
  loginForm: FormGroup;
  apiURL = 'http://localhost:8081/user/login';
  constructor(
  private fb: FormBuilder,
  public restApi: ApiService) {}

  ngOnInit() {
    this.loginForm = this.fb.group({  // Crée une instance de FormGroup
      username: ['toto'],                   // Crée une instance de FormControl
      password: ['113']                     // Crée une instance de FormControl
    });
  }

  login() {
    this.restApi.postUser(this.apiURL + '', this.loginForm.value);
  }
}
