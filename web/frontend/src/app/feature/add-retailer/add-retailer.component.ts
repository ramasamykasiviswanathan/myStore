import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-retailer',
  templateUrl: './add-retailer.component.html',
  styleUrls: ['./add-retailer.component.scss']
})
export class AddRetailerComponent implements OnInit {
  addNewShopForm: FormGroup;
  constructor(private fb: FormBuilder, private router: Router) {}

  ngOnInit() {
    this.addNewShopForm = this.fb.group({
      retailerCode: ['', [Validators.required, Validators.maxLength(10)]]
    });
    this.addNewShopForm.valueChanges.subscribe(data => {
      if (!this.addNewShopForm) {
        return;
      }
      console.log('addNewShopForm', this.addNewShopForm.value);
    });
  }
  addRetailer(form: any) {
    console.log('addRetailer', form);
  }
}
