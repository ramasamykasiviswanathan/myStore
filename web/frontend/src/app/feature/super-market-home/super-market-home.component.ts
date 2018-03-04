import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'app-super-market-home',
  templateUrl: './super-market-home.component.html',
  styleUrls: ['./super-market-home.component.scss']
})
export class SuperMarketHomeComponent implements OnInit {

  isCollapsedContent:boolean = false;
  
  opened: Boolean = false;
  toggle () {
    this.opened = !this.opened;
  }


  superMarketHomeForm: FormGroup;
  cols: { [key: string]: string } = {
    firstCol: 'row',
  };
  constructor(private fb: FormBuilder) { }

  ngOnInit() {
    this.superMarketHomeForm = this.fb.group({
      searchInput: [''],
    });
    this.superMarketHomeForm.valueChanges.subscribe(data => {
      if (!this.superMarketHomeForm) {
        return;
      }
      console.log('searchInput', this.superMarketHomeForm.get('searchInput').value);
    });
  }

}
