import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'app-feedback',
  templateUrl: './feedback.component.html',
  styleUrls: ['./feedback.component.scss']
})
export class FeedbackComponent implements OnInit {
  feedbackForm: FormGroup;

  constructor( private fb: FormBuilder) { }

  ngOnInit() {
    this.feedbackForm = this.fb.group({
      retailerName: ['', [Validators.required]],
      subject: ['', [Validators.required]],
      details: ['', [Validators.required]],
    });
    this.feedbackForm.valueChanges.subscribe(data => {
      if (!this.feedbackForm) {
        return;
      }
      console.log('retailerName', this.feedbackForm.get('retailerName').value);
      console.log('subject', this.feedbackForm.get('subject').value);
      console.log('details', this.feedbackForm.get('details').value);
    });
  }

  sendFeedBack() {
    
  }

}
