import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { LoginComponent } from '../../app/feature/login/login.component';
import { MaterialModule } from './material.module';

@NgModule({
  imports: [MaterialModule, FormsModule, ReactiveFormsModule, CommonModule],
  declarations: [LoginComponent],
  exports: [
    CommonModule,
    MaterialModule,
    FormsModule,
    ReactiveFormsModule,
    LoginComponent
  ]
})
export class SharedComponentModule {}
