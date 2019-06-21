import {Injectable} from '@angular/core';
import {BaseService} from '../base/base.service';
import {HTTP} from '@ionic-native/http/ngx';

@Injectable({
    providedIn: 'root'
})
export class PropietarioService extends BaseService {

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

        return this.http.post(this.getFullUrl() + 'owner-save', body, {headers});
    }
}
