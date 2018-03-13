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
import { ChangePasswordComponent } from '../../app/feature/change-password/change-password.component';
import { SignUpComponent } from '../../app/feature/sign-up/sign-up.component';
import { NewShopComponent } from '../../app/feature/new-shop/new-shop.component';
import { PharmaProductComponent } from '../../app/feature/pharma-product/pharma-product.component';
import { ProductComponent } from '../../app/feature/product/product.component';
import { PharmaHomeComponent } from '../../app/feature/pharma-home/pharma-home.component';
import { SuperMarketHomeComponent } from '../../app/feature/super-market-home/super-market-home.component';
import { InviteComponent } from '../../app/feature/invite/invite.component';
import { CategoryProductComponent } from '../../app/feature/category-product/category-product.component';
import { QuantityEditorComponent } from '../../app/feature/quantity-editor/quantity-editor.component';

@NgModule({
  imports: [
    MaterialModule,
    FormsModule,
    ReactiveFormsModule,
    CommonModule,
    CovalentModule
  ],
  declarations: [
    LoginComponent,
    DashboardComponent,
    MenuComponent,
    ForgotPasswordComponent,
    OtpComponent,
    ChangePasswordComponent,
    SignUpComponent,
    NewShopComponent,
    PharmaProductComponent,
    ProductComponent,
    PharmaHomeComponent,
    SuperMarketHomeComponent,
    InviteComponent,
    CategoryProductComponent,
    QuantityEditorComponent
  ],
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
    OtpComponent,
    ChangePasswordComponent,
    SignUpComponent,
    NewShopComponent,
    PharmaProductComponent,
    ProductComponent,
    PharmaHomeComponent,
    SuperMarketHomeComponent,
    InviteComponent,
    CategoryProductComponent,
    QuantityEditorComponent
  ]
})
export class SharedComponentModule {}
