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
  apiURL = 'b1/login';
  constructor(
  private fb: FormBuilder,
  public restApi: ApiService) {}

  ngOnInit() {
    this.loginForm = this.fb.group({  // Crée une instance de FormGroup
      name: [''],                   // Crée une instance de FormControl
      password: ['']                // Crée une instance de FormControl
    });
  }

  login() {
    this.restApi.postUser(this.apiURL, this.loginForm.value);
  }
}
