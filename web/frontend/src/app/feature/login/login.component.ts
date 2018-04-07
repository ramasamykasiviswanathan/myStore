import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
  loginForm: FormGroup;
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
  constructor( private fb: FormBuilder,
               private router: Router,
               private route: ActivatedRoute) {}

  ngOnInit() {
    this.loginForm = this.fb.group({
      userName: ['', [Validators.required]],
      password: ['', [Validators.required]],
      mobileNumber: ['', [Validators.required]],
      email: ['', [Validators.required]],
    });
    this.loginForm.valueChanges.subscribe(data => {
      if (!this.loginForm) {
        return;
      }
      console.log('userName', this.loginForm.get('userName').value);
      console.log('mobileNumber', this.loginForm.get('mobileNumber').value);
      console.log('email', this.loginForm.get('email').value);
      console.log('password', this.loginForm.get('password').value);
      console.log('data', data);
      console.log('this.loginForm.value', this.loginForm.value);
    });
  }

  authenticateLogin() {
     this.router.navigateByUrl('dashboard', {skipLocationChange: true});
  }
}

export interface Authenticate {
  userName?: String;
  password?: String;
  mobileNumber?: Number;
  email?: String;
}