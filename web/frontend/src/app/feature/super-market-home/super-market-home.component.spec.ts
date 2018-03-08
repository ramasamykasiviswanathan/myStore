import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SuperMarketHomeComponent } from './super-market-home.component';

describe('SuperMarketHomeComponent', () => {
  let component: SuperMarketHomeComponent;
  let fixture: ComponentFixture<SuperMarketHomeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SuperMarketHomeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SuperMarketHomeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
