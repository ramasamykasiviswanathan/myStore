import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router, ActivatedRoute, ParamMap } from '@angular/router';
import 'rxjs/add/operator/switchMap';
import { Observable } from 'rxjs/Observable';
import {
  IUserIdentity,
  IFlagMessageResponse
} from '../../shared/model/ExternalService.interface';
import { RemoteHttpService } from '../../shared/services/remote.service';

@Component({
  selector: 'app-otp',
  templateUrl: './otp.component.html',
  styleUrls: ['./otp.component.scss']
})
export class OtpComponent implements OnInit {
  otp: FormGroup;
  userIdentity: IUserIdentity;
  constructor(
    private _fb: FormBuilder,
    private _router: Router,
    private _activatedRoute: ActivatedRoute,
    private _remoteHttpService: RemoteHttpService
  ) {}

  ngOnInit() {
    this.userIdentity = {} as IUserIdentity;
    this._activatedRoute.paramMap.subscribe((params: ParamMap) => {
      this.userIdentity.Name = params.get('Name');
      this.userIdentity.MobileNumber = params.get('MobileNumber');
      this.userIdentity.EmailAddress = params.get('EmailAddress');
      this.userIdentity.Password = params.get('Password');
      /**
       * EmailAddress:"abc@cde.com"
       * MobileNumber:"213213213"
       * Name:"sadasd"
       * Password:"dsds"
       */
    });
    this.otp = this._fb.group({
      firstDigit: ['', [Validators.required]],
      secondDigit: ['', [Validators.required]],
      thirdDigit: ['', [Validators.required]],
      fourthDigit: ['', [Validators.required]]
    });
  }

  submitOTP(form: any) {
    this.userIdentity.OTP = [
      form.firstDigit,
      form.secondDigit,
      form.thirdDigit,
      form.fourthDigit
    ].join('');
    let response: IFlagMessageResponse;
    this._remoteHttpService
      .postSignupUserService(this.userIdentity)
      .subscribe(data => {
        console.log('SubmitOTP.response', response);
        response = data;
      });
    if (response.Message) {
      this._router.navigateByUrl('loginComponent', {
        skipLocationChange: true
      });
    }
  }
}
