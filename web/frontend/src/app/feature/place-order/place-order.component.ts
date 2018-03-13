import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'app-place-order',
  templateUrl: './place-order.component.html',
  styleUrls: ['./place-order.component.scss']
})
export class PlaceOrderComponent implements OnInit {
  retailerName: String;
  userName: String;
  streetName: String;
  city: String;
  mobileNumber: Number;
  emailID: String;
  addressList: Array<Address>;
  selected_address: String;

  placeOrderForm: FormGroup;

  constructor(private fb: FormBuilder) { }

  ngOnInit() {
    this.retailerName = 'Muthu Pharma';
    this.userName = 'Angelina John';
    this.streetName = '21630, 9th block, 12th Main Road First';
    this.city = 'AnnaNagar West, Chennai 600040(PIN)';
    this.mobileNumber = 9987446452;
    this.emailID = 'angelina.john@gmail.com';
    this.addressList = [
      {value: 'Home', viewValue: 'Abhiramapuram'},
      {value: 'Office', viewValue: 'Abhiramapuram'}
    ];
    this.selected_address = this.addressList[1].value;
    this.placeOrderForm = this.fb.group({
      patientName: [''],
      retailerName: [''],
      selected_address: [''],
    });
    this.placeOrderForm.valueChanges.subscribe(data => {
      if (!this.placeOrderForm) {
        return;
      }
      console.log('patientName', this.placeOrderForm.get('patientName').value);
      console.log('retailerName', this.placeOrderForm.get('retailerName').value);
      console.log('address', this.placeOrderForm.get('selected_address').value);
      console.log('address', this.placeOrderForm.get('delivery_option').value);
    });
  }

}

class Address {
  value: String;
  viewValue: String;
}
