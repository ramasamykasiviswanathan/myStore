import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-change-password',
  templateUrl: './change-password.component.html',
  styleUrls: ['./change-password.component.scss']
})
export class ChangePasswordComponent implements OnInit {
  changePassword: FormGroup;
  authenticate: Authenticate = {};
  cols: { [key: string]: string } = {
    firstCol: 'row',
    secondCol: 'column'
  };
  countryCodes = [
    { code: '+91', country: 'India' },
    { code: '+01', country: 'United States' },
    { code: '+06', country: 'Australia' }
  ];
  constructor(private fb: FormBuilder, private router: Router) {}

  ngOnInit() {
    this.changePassword = this.fb.group({
      oldPassword: ['', [Validators.required]],
      newPassword: ['', [Validators.required]],
      confirmPassword: ['', [Validators.required]]
    });
    this.changePassword.valueChanges.subscribe(data => {
      if (!this.changePassword) {
        return;
      }
      console.log('changePassword', this.changePassword.value);
    });
  }

  updatePassword() {
    this.router.navigateByUrl('dashboard', { skipLocationChange: true });
  }
}

export interface Authenticate {
  oldPassword?: String;
  newPassword?: String;
  confirmPassword?: String;
}
