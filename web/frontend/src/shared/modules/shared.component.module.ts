import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { LoginComponent } from '../../app/feature/login/login.component';
import { MaterialModule } from './material.module';
import { CovalentModule } from './covalent.module';

@NgModule({
  imports: [
    MaterialModule,
    FormsModule,
    ReactiveFormsModule,
    CommonModule,
    CovalentModule
  ],
  declarations: [LoginComponent],
  exports: [
    CommonModule,
    MaterialModule,
    CovalentModule,
    FormsModule,
    ReactiveFormsModule,
    LoginComponent
  ]
})
export class SharedComponentModule {}
