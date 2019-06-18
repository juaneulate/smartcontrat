import { CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ArrendatarioPage } from './arrendatario.page';

describe('ArrendatarioPage', () => {
  let component: ArrendatarioPage;
  let fixture: ComponentFixture<ArrendatarioPage>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ArrendatarioPage ],
      schemas: [CUSTOM_ELEMENTS_SCHEMA],
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ArrendatarioPage);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
