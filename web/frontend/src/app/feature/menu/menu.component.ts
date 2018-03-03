import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.scss']
})
export class MenuComponent implements OnInit {
  @Input() name: string;
  menuItems: Array<String> = [
    'My Stores',
    'My Profile',
    'My Orders',
    'Recurrence Order',
    'Add / Edit Delivery Address',
    'Change mobile/email',
    'Feedback',
    'Invite a friend',
    'About'
  ];
  current = 'My Stores';

  constructor() {
    console.log('app-menu Component');
  }

  ngOnInit() {}
}
