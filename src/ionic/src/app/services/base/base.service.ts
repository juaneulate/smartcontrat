import {Injectable} from '@angular/core';

@Injectable({
    providedIn: 'root'
})
export class BaseService {

    constructor() {
        this.baseUrl = 'http://52.14.41.220:8080/rest/';
    }

    protected baseUrl: string;
    protected controllerUrl: string;

    protected getFullUrl() {
        return this.baseUrl + this.controllerUrl;
    }
}
