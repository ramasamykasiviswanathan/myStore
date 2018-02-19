import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.scss']
})
export class DashboardComponent implements OnInit {
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

  constructor() {}

  ngOnInit() {}
}
