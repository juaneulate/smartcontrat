import { Injectable } from '@angular/core';
import { BaseService } from '../base/base.service';
import { HTTP } from '@ionic-native/http/ngx';

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


    save(fullName: string, age: number, login: string, password: string) {
        const headers = {
            'Content-Type': 'application/json'
        };

        const body = {
            fullName,
            age,
            login,
            password
        };

        this.http.setDataSerializer('json');
        return this.http.post(this.getFullUrl() + 'owner-save', body, headers);
    }
}
