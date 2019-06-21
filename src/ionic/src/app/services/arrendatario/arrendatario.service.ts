import {Injectable} from '@angular/core';
import {HTTP} from '@ionic-native/http/ngx';
import {BaseService} from '../base/base.service';

@Injectable({
    providedIn: 'root'
})
export class ArrendatarioService extends BaseService {

    constructor(
        private http: HTTP
    ) {
        super();
        this.controllerUrl = 'person/';
    }

    save(lastName: string, age: number, username: string, password: string) {
        const headers = {
            ContentType: 'application/json'
        };

        const body = {
            lastName,
            age,
            username,
            password
        };

        return this.http.post(this.getFullUrl() + 'tenant-save', body, {headers});
    }
}
