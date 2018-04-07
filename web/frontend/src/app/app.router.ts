import { Routes, RouterModule, ExtraOptions } from '@angular/router';

import { LoginComponent } from './feature/login/login.component';
import { DashboardComponent } from './feature/dashboard/dashboard.component';
import { SignUpComponent } from './feature/sign-up/sign-up.component';
import { ChangePasswordComponent } from './feature/change-password/change-password.component';
import { OtpComponent } from './feature/otp/otp.component';
import { ForgotPasswordOtpComponent } from './feature/forgot-password-otp/forgot-password-otp.component';
import { ForgotPasswordComponent } from './feature/forgot-password/forgot-password.component';

const routes: Routes = [
  { path: 'loginComponent', component: LoginComponent },
  { path: 'dashboard', component: DashboardComponent },
  { path: 'signUp', component: SignUpComponent },
  { path: 'requestOTP', component: OtpComponent },
  { path: 'forgotPasswordOtp', component: ForgotPasswordOtpComponent },
  { path: 'changePassword', component: ChangePasswordComponent },
  { path: 'forgotPassword', component: ForgotPasswordComponent }
];
const extraOptions: ExtraOptions = {
  enableTracing: true
};

export const routing = RouterModule.forRoot(routes, extraOptions);
