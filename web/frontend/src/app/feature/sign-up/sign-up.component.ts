import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.scss']
})
export class SignUpComponent implements OnInit {
  signUpForm: FormGroup;
  authenticate: Authenticate = {};
  cols: { [key: string]: string } = {
    firstCol: 'row'
  };
  countryCodes = [
    { code: '+91', country: 'India' },
    { code: '+01', country: 'United States' },
    { code: '+06', country: 'Australia' }
  ];
  constructor(private fb: FormBuilder, private router: Router) {}

  ngOnInit() {
    this.signUpForm = this.fb.group({
      userName: ['', [Validators.required]],
      password: ['', [Validators.required]],
      mobileNumber: ['', [Validators.required]],
      email: ['', [Validators.required]]
    });
    this.signUpForm.valueChanges.subscribe(data => {
      if (!this.signUpForm) {
        return;
      }
      console.log('signUpForm', this.signUpForm.value);
    });
  }

  signUp() {
    this.router.navigateByUrl('requestOTP', { skipLocationChange: true });
  }
}

export interface Authenticate {
  userName?: String;
  password?: String;
  mobileNumber?: Number;
  email?: String;
}
