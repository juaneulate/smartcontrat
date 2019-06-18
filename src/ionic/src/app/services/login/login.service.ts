import {Injectable} from '@angular/core';
import {HttpClient, HttpParams} from '@angular/common/http';

@Injectable({
    providedIn: 'root'
})
export class LoginService {

    constructor(
        private http: HttpClient
    ) {
    }

    baseUrl = 'http://52.15.237.224:8080/rest/user/';

    login(username: string, password: string) {
        // Initialize Params Object
        let params = new HttpParams();
        params = params.append('username', username);
        params = params.append('password', password);

        return this.http.get<boolean>(this.baseUrl + 'login', {params});
    }

    logout() {
        localStorage.removeItem('isLoggedIn');
        localStorage.removeItem('token');
        return null;
    }
}
