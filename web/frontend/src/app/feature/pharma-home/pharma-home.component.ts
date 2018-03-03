import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'app-pharma-home',
  templateUrl: './pharma-home.component.html',
  styleUrls: ['./pharma-home.component.scss']
})
export class PharmaHomeComponent implements OnInit {

  pharmaHomeForm: FormGroup;
  cols: { [key: string]: string } = {
    firstCol: 'row',
  };

  constructor(private fb: FormBuilder) { }

  ngOnInit() {
    this.pharmaHomeForm = this.fb.group({
      searchInput: [''],
    });
    this.pharmaHomeForm.valueChanges.subscribe(data => {
      if (!this.pharmaHomeForm) {
        return;
      }
      console.log('searchInput', this.pharmaHomeForm.get('searchInput').value);
    });
  }

}
