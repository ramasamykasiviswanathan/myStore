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
import {
  IUserIdentity,
  ICountryModel
} from '../../shared/model/ExternalService.interface';
import { RemoteHttpService } from '../../shared/services/remote.service';

@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.scss']
})
export class SignUpComponent implements OnInit {
  signUpForm: FormGroup;
  userIdentity: IUserIdentity;
  cols: { [key: string]: string } = {
    firstCol: 'row'
  };
  countryCodes: Array<ICountryModel>;
  constructor(
    private _fb: FormBuilder,
    private _router: Router,
    private _remoteHttpService: RemoteHttpService
  ) {}

  ngOnInit() {
    this.userIdentity = {} as IUserIdentity;
    this.signUpForm = this._fb.group({
      userName: ['', [Validators.required]],
      password: ['', [Validators.required]],
      mobileNumber: ['', [this.validateMobileNumber]],
      email: ['', [this.validateEmail]],
      country: ['']
    });
    this.signUpForm.valueChanges.subscribe(data => {
      if (!this.signUpForm) {
        return;
      }
    });
    this._remoteHttpService
      .getCountryService()
      .subscribe(data => (this.countryCodes = data));
  }

  signUp(form: any) {
    this.userIdentity.EmailAddress = form.email;
    if (form.mobileNumber) {
      const country: ICountryModel = form.country;
      this.userIdentity.MobileNumber =
        String(country.phoneCode) + String(form.mobileNumber);
    }
    this.userIdentity.Password = form.password;
    this.userIdentity.Name = form.userName;
    console.log('this.userIdentity', this.userIdentity);
    // this._remoteHttpService.postSignupUserService()
    this._router.navigateByUrl('requestOTP', { skipLocationChange: true });
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
        response = Validators.email(control);
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
