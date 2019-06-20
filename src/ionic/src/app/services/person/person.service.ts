import {Injectable} from '@angular/core';
import {HttpClient, HttpParams} from '@angular/common/http';
import {PersonModel} from '../../models/person.model';

@Injectable({
    providedIn: 'root'
})
export class PersonService {

    constructor(
        private http: HttpClient
    ) {
    }

    baseUrl = 'http://52.15.237.224:8080/rest/user/';

    get(login: string) {
        // Initialize Params Object
        let params = new HttpParams();
        params = params.append('login', login);

        console.log('previos call');

        return this.http.get<PersonModel>(this.baseUrl + 'get-person', {params});

    }
}
