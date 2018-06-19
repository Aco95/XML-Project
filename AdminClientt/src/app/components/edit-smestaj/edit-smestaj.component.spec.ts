import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EditSmestajComponent } from './edit-smestaj.component';

describe('EditSmestajComponent', () => {
  let component: EditSmestajComponent;
  let fixture: ComponentFixture<EditSmestajComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EditSmestajComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EditSmestajComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
