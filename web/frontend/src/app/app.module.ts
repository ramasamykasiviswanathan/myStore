import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { SharedComponentModule } from '../shared/modules/shared.component.module';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { OverlayContainer } from '@angular/cdk/overlay';
import { HttpClientModule } from '@angular/common/http';
import { SignUpComponent } from './feature/sign-up/sign-up.component';


@NgModule({
  declarations: [AppComponent, SignUpComponent],
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
