import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'app-invite',
  templateUrl: './invite.component.html',
  styleUrls: ['./invite.component.scss']
})
export class InviteComponent implements OnInit {
  inviteForm: FormGroup;
  public retailerList: Array<Retailer>;
  constructor(private fb: FormBuilder) { }

  ngOnInit() {
    this.inviteForm = this.fb.group({
      inviteInput: [''],
    });
    this.retailerList = [
      {name: 'Muthu Parmacy'},
      {name: 'Pondy Medicals'},
      {name: 'AppoloPharmacy'},
      {name: 'Nilgiris SuperMarket'},
      {name: 'Alagu Pahrmacy'},
      {name: 'Spencers Daily'}
    ];
    this.inviteForm.valueChanges.subscribe(data => {
      if (!this.inviteForm) {
        return;
      }
      console.log('inviteInput', this.inviteForm.get('inviteInput').value);
    });
  }


}

class Retailer {
  name: String;
}
