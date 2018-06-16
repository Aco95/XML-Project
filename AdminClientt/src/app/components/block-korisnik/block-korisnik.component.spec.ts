import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BlockKorisnikComponent } from './block-korisnik.component';

describe('BlockKorisnikComponent', () => {
  let component: BlockKorisnikComponent;
  let fixture: ComponentFixture<BlockKorisnikComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BlockKorisnikComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BlockKorisnikComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
