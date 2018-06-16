import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ManageKorisnikComponent } from './manage-korisnik.component';

describe('BlockKorisnikComponent', () => {
  let component: ManageKorisnikComponent;
  let fixture: ComponentFixture<ManageKorisnikComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ManageKorisnikComponent]
    })
      .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ManageKorisnikComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
