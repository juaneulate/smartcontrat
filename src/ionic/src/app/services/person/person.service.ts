import {Injectable} from '@angular/core';
import {BaseService} from '../base/base.service';
import {HTTP} from '@ionic-native/http/ngx';

@Injectable({
    providedIn: 'root'
})
export class PersonService extends BaseService {

    constructor(
        private http: HTTP
    ) {
        super();
        this.controllerUrl = 'login/';
    }

    get(username: string) {
        // Initialize Params Object
        const params = {
            username
        };

        return this.http.get(this.getFullUrl() + 'get-person', params, {});

    }
}
