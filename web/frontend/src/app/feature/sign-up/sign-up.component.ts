import { Component, OnInit } from '@angular/core';
import {
  FormBuilder,
  FormGroup,
  FormArray,
  Validators,
  FormControl,
  ValidationErrors
} from '@angular/forms';
import { Router } from '@angular/router';
import { IUserIdentity } from '../../shared/model/ExternalService.interface';

@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.scss']
})
export class SignUpComponent implements OnInit {
  signUpForm: FormGroup;
  authenticate: IUserIdentity;
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
    this.authenticate = {} as IUserIdentity;
    this.signUpForm = this.fb.group({
      userName: ['', [Validators.required]],
      password: ['', [Validators.required]],
      mobileNumber: ['', [this.validateMobileNumber]],
      email: ['', [Validators.email, this.validateEmail]],
      country: ['']
    });
    this.signUpForm.valueChanges.subscribe(data => {
      if (!this.signUpForm) {
        return;
      }
      console.log('signUpForm', this.signUpForm.value);
    });
  }

  signUp(form: any) {
    console.log('form', form);
    this.router.navigateByUrl('requestOTP', { skipLocationChange: true });
  }

  private validateMobileNumber(control: FormControl): ValidationErrors {
    let response: ValidationErrors = null;
    const parent: FormGroup | FormArray = control.parent;
    if (parent) {
      const emailControl: FormControl = parent.controls['email'];
      const countryControl: FormControl = parent.controls['country'];
      if (control.value) {
        emailControl.setErrors(null);
        if (!countryControl.value) {
          countryControl.setErrors({
            message: 'Required field'
          });
        }
      } else if (!emailControl.value) {
        response = {
          message: 'Required field'
        };
      }
    }
    return response;
  }

  private validateEmail(control: FormControl): ValidationErrors {
    let response: ValidationErrors = null;
    const parent: FormGroup | FormArray = control.parent;
    if (parent) {
      const mobileNumberControl: FormControl = parent.controls['mobileNumber'];
      if (control.value) {
        mobileNumberControl.setErrors(null);
      } else if (!mobileNumberControl.value) {
        response = {
          message: 'Required field'
        };
      }
    }
    return response;
  }
}
