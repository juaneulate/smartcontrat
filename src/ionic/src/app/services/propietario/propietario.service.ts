import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';

@Injectable({
    providedIn: 'root'
})
export class PropietarioService {

    constructor(
        private http: HttpClient
    ) {
    }

    baseUrl = 'http://52.15.237.224:8080/rest/person/';

    save(lastName: string, age: number, username: string, password: string) {
        const headers = new HttpHeaders();
        headers.append('Content-Type', 'application/json');

        const body = {
            lastName,
            age,
            username,
            password
        };

        return this.http.post<boolean>(this.baseUrl + 'propietary-save', body, {headers});

    }

    get(username: string) {
        const headers = new HttpHeaders();
        headers.append('Content-Type', 'application/json');

        const body = {
            username
        };

        return this.http.post<boolean>(this.baseUrl + 'propietary-get', body, {headers});

    }
}
