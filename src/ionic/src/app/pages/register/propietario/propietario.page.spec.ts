import { CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PropietarioPage } from './propietario.page';

describe('PropietarioPage', () => {
  let component: PropietarioPage;
  let fixture: ComponentFixture<PropietarioPage>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PropietarioPage ],
      schemas: [CUSTOM_ELEMENTS_SCHEMA],
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PropietarioPage);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
