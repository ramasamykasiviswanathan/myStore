import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'app-pharma-product',
  templateUrl: './pharma-product.component.html',
  styleUrls: ['./pharma-product.component.scss']
})
export class PharmaProductComponent implements OnInit {

  pharmaProductForm: FormGroup;
  cols: { [key: string]: string } = {
    firstCol: 'row',
  };

  constructor(private fb: FormBuilder) { }

  ngOnInit() {
    this.pharmaProductForm = this.fb.group({
      searchInput: [''],
    });
    this.pharmaProductForm.valueChanges.subscribe(data => {
      if (!this.pharmaProductForm) {
        return;
      }
      console.log('searchInput', this.pharmaProductForm.get('searchInput').value);
    });
  }

}
