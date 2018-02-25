import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'app-new-shop',
  templateUrl: './new-shop.component.html',
  styleUrls: ['./new-shop.component.scss']
})
export class NewShopComponent implements OnInit {

  newShopForm: FormGroup;
  cols: { [key: string]: string } = {
    firstCol: 'row',
  };

  constructor(private fb: FormBuilder) { }

  ngOnInit() {
    this.newShopForm = this.fb.group({
      retailerCode: ['', Validators.compose([Validators.required, Validators.minLength(10), Validators.maxLength(10)])],
    });
    this.newShopForm.valueChanges.subscribe(data => {
      if (!this.newShopForm) {
        return;
      }
      console.log('retailerCode', this.newShopForm.get('retailerCode').value);
    });
  }

}

