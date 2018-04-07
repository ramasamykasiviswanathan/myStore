import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import 'rxjs/add/operator/map';
import { environment } from '../../../environments/environment';
import {
  IUserIdentity,
  IFlagMessageResponse,
  ILoginResponse,
  IShowShopsResponse
} from '../model/ExternalService.interface';

@Injectable()
export class RemoteHttpService {
  constructor(private _http: HttpClient) {}

  populateHttpHeader = (
    httpHeaders = new HttpHeaders(),
    userId?: String | Number
  ): HttpHeaders => {
    return httpHeaders
      .set('Content-Type', 'application/json; charset=utf8')
      .set('AppId', String(environment.APPID))
      .set('userId', String(userId));
  };

  stringifyObject = <T>(input: T): String | null => {
    let value: String | null = null;
    if (input) {
      value = JSON.stringify(input);
    }
    return value;
  };

  public postLoginService(
    userIdentity: IUserIdentity,
    httpHeaders?: HttpHeaders
  ): Observable<ILoginResponse> {
    return this._http.post<ILoginResponse>(
      environment.URL + environment.path.LOGIN,
      this.stringifyObject(userIdentity),
      { headers: this.populateHttpHeader(httpHeaders) }
    );
  }

  public postForgotPasswordService(
    userIdentity: IUserIdentity,
    httpHeaders?: HttpHeaders
  ): Observable<IFlagMessageResponse> {
    return this._http.post<IFlagMessageResponse>(
      environment.URL + environment.path.FORGOTPASSWORD,
      this.stringifyObject(userIdentity),
      {
        headers: this.populateHttpHeader(httpHeaders)
      }
    );
  }

  public postChangePasswordService(
    userIdentity: IUserIdentity,
    userId?: String | Number,
    httpHeaders?: HttpHeaders
  ): Observable<IFlagMessageResponse> {
    return this._http.post<IFlagMessageResponse>(
      environment.URL + environment.path.CHANGEPASSWORD,
      this.stringifyObject(userIdentity),
      {
        headers: this.populateHttpHeader(httpHeaders, userId)
      }
    );
  }

  public postAddRetailerService(
    userIdentity: IUserIdentity,
    userId?: String | Number,
    httpHeaders?: HttpHeaders
  ): Observable<IFlagMessageResponse> {
    return this._http.post<IFlagMessageResponse>(
      environment.URL + environment.path.ADDRETAILER,
      this.stringifyObject(userIdentity),
      {
        headers: this.populateHttpHeader(httpHeaders, userId)
      }
    );
  }

  public postSignupUserService(
    userIdentity: IUserIdentity,
    httpHeaders?: HttpHeaders
  ): Observable<IFlagMessageResponse> {
    return this._http.post<IFlagMessageResponse>(
      environment.URL + environment.path.SIGNUPUSER,
      this.stringifyObject(userIdentity),
      {
        headers: this.populateHttpHeader(httpHeaders)
      }
    );
  }

  public getShowShopsService(
    userId: String | Number,
    httpHeaders?: HttpHeaders
  ): Observable<IShowShopsResponse> {
    return this._http.post<IShowShopsResponse>(
      environment.URL + environment.path.SHOWSHOPS,
      {
        headers: this.populateHttpHeader(httpHeaders, userId)
      }
    );
  }
}
