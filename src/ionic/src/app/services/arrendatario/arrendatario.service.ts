import { Injectable } from '@angular/core';
import { HTTP } from '@ionic-native/http/ngx';
import { BaseService } from '../base/base.service';

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
        return this.http.post(this.getFullUrl() + 'tenant-save', body, headers);
    }
}
