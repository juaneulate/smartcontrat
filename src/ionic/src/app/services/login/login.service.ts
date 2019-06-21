import {Injectable} from '@angular/core';
import {HTTP} from '@ionic-native/http/ngx';
import {BaseService} from '../base/base.service';

@Injectable({
    providedIn: 'root'
})
export class LoginService extends BaseService {

    constructor(
        private http: HTTP
    ) {
        super();
        this.controllerUrl = 'login/';
    }


    login(username: string, password: string) {
        // Initialize Params Object
        const params = {
            username,
            password
        };
        return this.http.get(this.getFullUrl() + 'validate', params, {});
    }

    logout() {
        localStorage.removeItem('isLoggedIn');
        localStorage.removeItem('token');
        return null;
    }
}
