import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { ApiService } from '../api-service.service';

@Component({
  selector: 'app-inscription',
  templateUrl: './inscription.component.html',
  styleUrls: ['./inscription.component.css']
})

export class InscriptionComponent implements OnInit {
  loginForm: FormGroup;
  apiURL = 'b1';

  constructor(
    private fb: FormBuilder,
    public restApi: ApiService) {}

  ngOnInit() {
    this.loginForm = this.fb.group({  // Crée une instance de FormGroup
      name: [''],                   // Crée une instance de FormControl
      password: [''],
      apikey: [''],
      apikeysecret: [''],
      accesstoken: [''],
      accesstokensecret: ['']                  // Crée une instance de FormControl
    });
  }
  register() {
    this.restApi.postUser(this.apiURL, this.loginForm.value);
  }
}


