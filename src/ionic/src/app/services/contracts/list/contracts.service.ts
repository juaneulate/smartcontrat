import { Injectable } from '@angular/core';
import { HTTP } from '@ionic-native/http/ngx';
import { BaseService } from '../../base/base.service';

@Injectable({
    providedIn: 'root'
})
export class ContractsService extends BaseService {

    constructor(
        private http: HTTP
    ) {
        super();
        this.controllerUrl = 'contract/';
    }

    list(username: string) {
        // Initialize Params Object
        const params = {
            username
        };

        return this.http.get(this.getFullUrl() + 'list', params, {});
    }

    save(registroBilletera: string, montoTotal: number, cuota: number, nombreContrato: string, hashContract: string) {
        const headers = {
            'Content-Type': 'application/json'
        };

        const jsonContract = '';
        const username = localStorage.getItem('token');

        const body = {
            registroBilletera,
            montoTotal,
            cuota,
            nombreContrato,
            hashContract,
            jsonContract,
            username
        };
        this.http.setDataSerializer('json');
        return this.http.post(this.getFullUrl() + 'save', body, headers);
    }

    get(contract_id: number) {
        // Initialize Params Object
        const params = {
            contract_id
        };

        return this.http.get(this.getFullUrl() + 'get-contract', params, {});
    }
}
