import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.scss']
})
export class SignUpComponent implements OnInit {

  signUpForm: FormGroup;
  authenticate: Authenticate = {};
  cols: { [key: string]: string } = {
    firstCol: 'row',
  };
  countryCodes = [
    {code: '+91', country: 'India'},
    {code: '+01', country: 'United States'},
    {code: '+06', country: 'Australia'},
  ];
  hide = true;
  constructor(private fb: FormBuilder) {}

  ngOnInit() {
    this.signUpForm = this.fb.group({
      userName: ['', [Validators.required]],
      password: ['', [Validators.required]],
      mobileNumber: ['', [Validators.required]],
      email: ['', [Validators.required]],
    });
    this.signUpForm.valueChanges.subscribe(data => {
      if (!this.signUpForm) {
        return;
      }
      console.log('userName', this.signUpForm.get('userName').value);
      console.log('mobileNumber', this.signUpForm.get('mobileNumber').value);
      console.log('email', this.signUpForm.get('email').value);
      console.log('password', this.signUpForm.get('password').value);
      console.log('data', data);
      console.log('this.loginForm.value', this.signUpForm.value);
    });
  }
}

export interface Authenticate {
  userName?: String;
  password?: String;
  mobileNumber?: Number;
  email?: String;
}