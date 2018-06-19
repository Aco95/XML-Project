import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SmestajComponent } from './smestaj.component';

describe('SmestajComponent', () => {
  let component: SmestajComponent;
  let fixture: ComponentFixture<SmestajComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SmestajComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SmestajComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
