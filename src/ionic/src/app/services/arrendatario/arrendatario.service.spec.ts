import { TestBed } from '@angular/core/testing';

import { ArrendatarioService } from './arrendatario.service';

describe('ArrendatarioService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: ArrendatarioService = TestBed.get(ArrendatarioService);
    expect(service).toBeTruthy();
  });
});
