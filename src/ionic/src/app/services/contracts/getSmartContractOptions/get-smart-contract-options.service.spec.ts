import { TestBed } from '@angular/core/testing';

import { GetSmartContractOptionsService } from './get-smart-contract-options.service';

describe('GetSmartContractOptionsService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: GetSmartContractOptionsService = TestBed.get(GetSmartContractOptionsService);
    expect(service).toBeTruthy();
  });
});
