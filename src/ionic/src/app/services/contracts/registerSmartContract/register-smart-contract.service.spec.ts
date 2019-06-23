import { TestBed } from '@angular/core/testing';

import { RegisterSmartContractService } from './register-smart-contract.service';

describe('RegisterSmartContractService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: RegisterSmartContractService = TestBed.get(RegisterSmartContractService);
    expect(service).toBeTruthy();
  });
});
