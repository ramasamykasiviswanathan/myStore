import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { LoginComponent } from '../../app/feature/login/login.component';
import { DashboardComponent } from '../../app/feature/dashboard/dashboard.component';
import { MenuComponent } from '../../app/feature/menu/menu.component';
import { MaterialModule } from './material.module';
import { CovalentModule } from './covalent.module';
import { ForgotPasswordComponent } from '../../app/feature/forgot-password/forgot-password.component';
import { ForgotPasswordOtpComponent } from '../../app/feature/forgot-password-otp/forgot-password-otp.component';
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
import { PlaceOrderComponent } from '../../app/feature/place-order/place-order.component';
import { IconComponent } from '../../app/shared/icon/icon.component';
import { routing } from '../../app/app.router';
import { RemoteHttpService } from '../../app/shared/services/remote.service';
import { SingletonService } from '../../app/shared/services/singleton.service';
import { AddRetailerComponent } from '../../app/feature/add-retailer/add-retailer.component';
import { UserProfileComponent } from '../../app/feature/user-profile/user-profile.component';
import { FeedbackComponent } from '../../app/feature/feedback/feedback.component';

@NgModule({
  imports: [
    MaterialModule,
    FormsModule,
    ReactiveFormsModule,
    CommonModule,
    CovalentModule,
    RouterModule.forRoot([]),
    routing
  ],
  declarations: [
    LoginComponent,
    DashboardComponent,
    MenuComponent,
    ForgotPasswordComponent,
    ForgotPasswordOtpComponent,
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
    QuantityEditorComponent,
    PlaceOrderComponent,
    IconComponent,
    AddRetailerComponent,
    UserProfileComponent,
    FeedbackComponent
  ],
  exports: [
    RouterModule,
    CommonModule,
    MaterialModule,
    CovalentModule,
    FormsModule,
    ReactiveFormsModule,
    LoginComponent,
    DashboardComponent,
    MenuComponent,
    ForgotPasswordComponent,
    ForgotPasswordOtpComponent,
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
    QuantityEditorComponent,
    PlaceOrderComponent,
    IconComponent,
    AddRetailerComponent,
    UserProfileComponent,
    FeedbackComponent
  ],
  providers: [RemoteHttpService, SingletonService]
})
export class SharedComponentModule {}
