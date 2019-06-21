import {Component, OnInit} from '@angular/core';
import {FormControl} from '@angular/forms';

@Component({
    selector: 'app-home',
    templateUrl: 'home.page.html',
    styleUrls: ['home.page.scss'],
})
export class HomePage implements OnInit {
    username: string;
    searchControl: FormControl;
    showResults = false;
    searchText: any;

    constructor() {
    }

    ngOnInit() {
        this.searchControl = new FormControl();
    }

    onChange() {
        const login = this.searchControl.value;
        console.log(login);
        if (login != null) {
            this.searchText = login;
            this.showResults = true;
        } else {
            this.showResults = false;
        }
    }
}
