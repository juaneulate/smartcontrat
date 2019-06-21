import {Component, OnInit} from '@angular/core';
import {PersonService} from '../../services/person/person.service';
import {ErrorService} from '../../services/error/error.service';
import {AlertService} from '../../services/alert/alert.service';
import {FormControl} from '@angular/forms';
import {Platform} from '@ionic/angular';

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

    constructor(
        private personService: PersonService,
        private errorService: ErrorService,
        private alertService: AlertService,
        private platform: Platform
    ) {
        this.username = localStorage.getItem('token');
        console.log(this.username);
    }

    ngOnInit() {
        this.searchControl = new FormControl();
        this.platform.ready().then(dataP => {
            console.log(dataP);
            this.personService.get(this.username)
                .then(data => {
                    console.log(data);

                    localStorage.setItem('fullname', data.data['lastname']);
                    localStorage.setItem('age', data.data['age']);

                    if (data.data['tipoPersona']) {
                        localStorage.setItem('type', 'owner');
                    } else {
                        localStorage.setItem('type', 'tenant');
                    }
                })
                .catch(error => {
                    this.errorService.consoleLog(error);
                    this.errorService.alertError(error);
                });
        });
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
