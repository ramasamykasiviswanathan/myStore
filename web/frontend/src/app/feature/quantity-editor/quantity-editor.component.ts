import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-quantity-editor',
  templateUrl: './quantity-editor.component.html',
  styleUrls: ['./quantity-editor.component.scss']
})
export class QuantityEditorComponent implements OnInit {
  @Input() delete: Boolean = false;
  constructor() {}

  ngOnInit() {}
  logme = event => console.log('rama', event);
}
