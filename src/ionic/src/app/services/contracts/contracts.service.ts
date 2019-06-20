import {Injectable} from '@angular/core';
import {HttpClient, HttpParams} from '@angular/common/http';
import {ContractModel} from '../../models/contract.model';

@Injectable({
    providedIn: 'root'
})
export class ContractsService {

    constructor(
        private http: HttpClient
    ) {
    }

    baseUrl = 'http://52.15.237.224:8080/rest/contract/';


    list(login: string) {
        // Initialize Params Object
        let params = new HttpParams();
        params = params.append('login', login);

        return this.http.get<ContractModel[]>(this.baseUrl + 'list', {params});
    }
}
