import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
  loginForm: FormGroup;
  authenticate: Authenticate = {};
  cols: { [key: string]: string } = {
    firstCol: 'row',
    firstColXs: 'column',
    firstColMd: 'column',
    firstColLg: 'column',
    firstColGtLg: 'column',
    secondCol: 'column'
  };
  hide = true;
  constructor(private fb: FormBuilder) {}

  ngOnInit() {
    this.loginForm = this.fb.group({
      userName: ['', [Validators.required]],
      password: ['', [Validators.required]]
    });
    this.loginForm.valueChanges.subscribe(data => {
      if (!this.loginForm) {
        return;
      }
      console.log('userName', this.loginForm.get('userName').value);
      console.log('password', this.loginForm.get('password').value);
      console.log('data', data);
      console.log('this.loginForm.value', this.loginForm.value);
    });
  }
}

export interface Authenticate {
  userName?: String;
  password?: String;
}
