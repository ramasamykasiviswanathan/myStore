import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';


@Component({
  selector: 'app-forgot-password-otp',
  templateUrl: './forgot-password-otp.component.html',
  styleUrls: ['./forgot-password-otp.component.scss']
})
export class ForgotPasswordOtpComponent implements OnInit {
  forgotPasswordOtp: FormGroup;
  authenticate: Authenticate = {};
  cols: { [key: string]: string } = {
    firstCol: 'row',
  };
  hide = true;
  constructor( private fb: FormBuilder,
               private router: Router) {}

  ngOnInit() {
    this.forgotPasswordOtp = this.fb.group({
      firstDigit: ['', [Validators.required]],
      secondDigit: ['', [Validators.required]],
      thirdDigit: ['', [Validators.required]],
      fourthDigit: ['', [Validators.required]],
      newPassword: ['', [Validators.required]],
      confirmPassword: ['', [Validators.required]] 
    });
    this.forgotPasswordOtp.valueChanges.subscribe(data => {
      if (!this.forgotPasswordOtp) {
        return;
      }
      console.log('firstDigit', this.forgotPasswordOtp.get('firstDigit').value);
      console.log('secondDigit', this.forgotPasswordOtp.get('secondDigit').value);
      console.log('thirdDigit', this.forgotPasswordOtp.get('thirdDigit').value);
      console.log('fourthDigit', this.forgotPasswordOtp.get('fourthDigit').value);
    });
  }

  setPassword() {
    this.router.navigateByUrl('dashboard', {skipLocationChange: true});
  }

}

export interface Authenticate {
  firstDigit?: Number;
  secondDigit?: Number;
  thirdDigit?: Number;
  fourthDigit?: Number;
}

