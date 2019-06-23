import { Injectable } from '@angular/core';
import { extend } from 'webdriver-js-extender';
import { BaseService } from '../../base/base.service';
import { HTTP } from '@ionic-native/http/ngx';

@Injectable({
  providedIn: 'root'
})
export class GetSmartContractOptionsService extends BaseService {

  constructor(
    private http: HTTP
  ) {
    super();
    this.controllerUrl = 'contract/';
  }

  execute(contractId: number) {
    // Initialize Params Object
    const params = {
      contract_id: contractId
    };

    return this.http.get(this.getFullUrl() + 'get-contract', params, {});
  }
}
