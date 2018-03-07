import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { SharedComponentModule } from '../shared/modules/shared.component.module';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { OverlayContainer } from '@angular/cdk/overlay';
import { HttpClientModule } from '@angular/common/http';
import { SignUpComponent } from './feature/sign-up/sign-up.component';
import { NewShopComponent } from './feature/new-shop/new-shop.component';
import { PharmaProductComponent } from './feature/pharma-product/pharma-product.component';
import { ProductComponent } from './feature/product/product.component';
import { PharmaHomeComponent } from './feature/pharma-home/pharma-home.component';
import { SuperMarketHomeComponent } from './feature/super-market-home/super-market-home.component';
import { InviteComponent } from './feature/invite/invite.component';


@NgModule({
  declarations: [AppComponent, SignUpComponent, NewShopComponent, PharmaProductComponent, ProductComponent, PharmaHomeComponent, SuperMarketHomeComponent, InviteComponent],
  imports: [
    BrowserAnimationsModule,
    BrowserModule,
    SharedComponentModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
  constructor(overlayContainer: OverlayContainer) {}
}
