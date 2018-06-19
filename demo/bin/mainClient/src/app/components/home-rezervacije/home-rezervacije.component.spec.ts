import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HomeRezervacijeComponent } from './home-rezervacije.component';

describe('HomeRezervacijeComponent', () => {
  let component: HomeRezervacijeComponent;
  let fixture: ComponentFixture<HomeRezervacijeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HomeRezervacijeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HomeRezervacijeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
