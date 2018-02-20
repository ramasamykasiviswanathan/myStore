import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'app-forgot-password',
  templateUrl: './forgot-password.component.html',
  styleUrls: ['./forgot-password.component.scss']
})
export class ForgotPasswordComponent implements OnInit {

  forgotPassword
  : FormGroup;
  authenticate: Authenticate = {};
  cols: { [key: string]: string } = {
    firstCol: 'row',
    firstColXs: 'column',
    firstColMd: 'column',
    firstColLg: 'column',
    firstColGtLg: 'column',
    secondCol: 'column'
  };
  countryCodes = [
    {code: '+91', country: 'India'},
    {code: '+01', country: 'United States'},
    {code: '+06', country: 'Australia'},
  ];
  hide = true;
  constructor(private fb: FormBuilder) {}

  ngOnInit() {
    this.forgotPassword = this.fb.group({
      countryCode: ['', [Validators.required]],
      mobileNumber: ['', [Validators.required]],
      emailID: ['', [Validators.required]]
    });
    this.forgotPassword.valueChanges.subscribe(data => {
      if (!this.forgotPassword) {
        return;
      }
      console.log('countryCode', this.forgotPassword.get('countryCode').value);
      console.log('mobileNumber', this.forgotPassword.get('mobileNumber').value);
      console.log('emailID', this.forgotPassword.get('emailID').value);
      console.log('data', data);
      console.log('this.forgotPassword.value', this.forgotPassword.value);
    });
  }

}

export interface Authenticate {
  countryCode?: Number;
  mobileNumber?: Number;
  emailID?: String;
}
