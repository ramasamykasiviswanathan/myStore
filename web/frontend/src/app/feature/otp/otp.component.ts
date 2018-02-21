import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'app-otp',
  templateUrl: './otp.component.html',
  styleUrls: ['./otp.component.scss']
})
export class OtpComponent implements OnInit {

  otp: FormGroup;
  authenticate: Authenticate = {};
  cols: { [key: string]: string } = {
    firstCol: 'row',
  };
  hide = true;
  constructor(private fb: FormBuilder) {}

  ngOnInit() {
    this.otp = this.fb.group({
      firstDigit: ['', [Validators.required]],
      secondDigit: ['', [Validators.required]],
      thirdDigit: ['', [Validators.required]],
      fourthDigit: ['', [Validators.required]],
    });
    this.otp.valueChanges.subscribe(data => {
      if (!this.otp) {
        return;
      }
      console.log('firstDigit', this.otp.get('firstDigit').value);
      console.log('secondDigit', this.otp.get('secondDigit').value);
      console.log('thirdDigit', this.otp.get('thirdDigit').value);
      console.log('fourthDigit', this.otp.get('fourthDigit').value);
    });
  }

}

export interface Authenticate {
    firstDigit?: Number;
    secondDigit?: Number;
    thirdDigit?: Number;
    fourthDigit?: Number;
}
