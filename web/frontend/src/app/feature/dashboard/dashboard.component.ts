import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.scss']
})
export class DashboardComponent implements OnInit {
  _service_value = [
    {
      icon: 'shopping_cart',
      name: 'MUTHU PHARMACY',
      notification: null
    },
    {
      icon: 'shopping_cart',
      name: 'PONDY MEDICALS',
      notification: null
    },
    {
      icon: 'shopping_cart',
      name: 'APOLLO PHARMACY',
      notification: 12
    },
    {
      icon: 'shopping_cart',
      name: 'Nilgiris Supermarket',
      notification: null
    },
    {
      icon: 'shopping_cart',
      name: 'Alagu Pharmacy',
      notification: null
    },
    {
      icon: 'shopping_cart',
      name: 'Spencers Daily',
      notification: null
    }
  ];
  constructor() {
    console.log('app-dashboard Component');
  }

  ngOnInit() {}

  tilesData(service_value) {
    let minCount = 9;
    if (service_value && service_value.length > 0) {
      minCount =
        service_value.length > minCount
          ? service_value.length % 3 === 0
            ? service_value.length + 3
            : service_value.length
          : minCount;
    }
    while (--minCount >= 0) {}
  }
}

interface DisplayTile {
  icon: String;
  name: String;
  notification: Number;
  showClose?: Boolean;
}
