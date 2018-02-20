import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { LoginComponent } from '../../app/feature/login/login.component';
import { DashboardComponent } from '../../app/feature/dashboard/dashboard.component';
import { MenuComponent } from '../../app/feature/menu/menu.component';
import { MaterialModule } from './material.module';
import { CovalentModule } from './covalent.module';
import { ForgotPasswordComponent } from '../../app/feature/forgot-password/forgot-password.component';
import { OtpComponent } from '../../app/feature/otp/otp.component';

@NgModule({
  imports: [
    MaterialModule,
    FormsModule,
    ReactiveFormsModule,
    CommonModule,
    CovalentModule
  ],
  declarations: [LoginComponent, DashboardComponent, MenuComponent, ForgotPasswordComponent, OtpComponent],
  exports: [
    CommonModule,
    MaterialModule,
    CovalentModule,
    FormsModule,
    ReactiveFormsModule,
    LoginComponent,
    DashboardComponent,
    MenuComponent,
    ForgotPasswordComponent,
    OtpComponent
  ]
})
export class SharedComponentModule {}
