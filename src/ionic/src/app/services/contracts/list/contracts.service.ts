import {Injectable} from '@angular/core';
import {HTTP} from '@ionic-native/http/ngx';
import {BaseService} from '../../base/base.service';

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
}
