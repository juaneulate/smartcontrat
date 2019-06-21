import {Injectable} from '@angular/core';

@Injectable({
    providedIn: 'root'
})
export class BaseService {

    constructor() {
        this.baseUrl = 'http://52.15.237.224:8080/rest/';
    }

    protected baseUrl: string;
    protected controllerUrl: string;

    protected getFullUrl() {
        return this.baseUrl + this.controllerUrl;
    }
}
