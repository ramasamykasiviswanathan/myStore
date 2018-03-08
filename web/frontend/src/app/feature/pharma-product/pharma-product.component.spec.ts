import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PharmaProductComponent } from './pharma-product.component';

describe('PharmaProductComponent', () => {
  let component: PharmaProductComponent;
  let fixture: ComponentFixture<PharmaProductComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PharmaProductComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PharmaProductComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
