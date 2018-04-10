import { Injectable, OnInit } from '@angular/core';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class SingletonService implements OnInit {
  constructor() {}

  private _userID: String | Number = null;

  get userID() {
    return this._userID;
  }
  set userID(id: String | Number) {
    this._userID = id;
  }

  ngOnInit(): void {
    this.userID = 18;
  }
}
