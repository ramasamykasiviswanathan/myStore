import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-category-product',
  templateUrl: './category-product.component.html',
  styleUrls: ['./category-product.component.scss']
})
export class CategoryProductComponent implements OnInit {
  values: String[];
  constructor() {}

  ngOnInit() {
    this.values = [
      '2% Fat Milk',
      'Low Fat Milk',
      'Fat-Free Milk',
      'Whole Lactose Reduced Milk',
      '2% Fat Lactose Reduced Milk',
      'Fat-Free Lactose Reduced Milk',
      '2% Fat Lactose-Free Milk',
      'Fat-Free Lactose-FreeMilk',
      'Powdered (Dry) Milk',
      'Nonfat Powdered (Dry) Milk',
      'Evaporated Milk'
    ];
  }
}
