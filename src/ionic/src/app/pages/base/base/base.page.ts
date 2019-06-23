import { Component, OnInit } from '@angular/core';
import { Platform, NavController } from '@ionic/angular';
import { PersonService } from '../../../services/person/person.service';
import { ErrorService } from '../../../services/error/error.service';

@Component({
    selector: 'app-base',
    templateUrl: './base.page.html',
    styleUrls: ['./base.page.scss'],
})
export class BasePage implements OnInit {

    public pagesOwner = [
        { title: 'Home', url: '/base/main/home', icon: 'home' },
        { title: 'List', url: '/base/main/list', icon: 'list' },
        { title: 'Crear Contrato', url: '/base/main/contract/create', icon: 'list-box' }
    ];

    public pagesTenant = [
        { title: 'Home', url: '/base/main/home', icon: 'home' },
        { title: 'List', url: '/base/main/list', icon: 'list' },
    ];

    showOwner: boolean;
    showTenant: boolean;
    username: string;

    constructor(
        private personService: PersonService,
        private errorService: ErrorService,
        private platform: Platform,
        private navCtrl: NavController
    ) {
        this.username = localStorage.getItem('token');
        console.log(this.username);
    }

    ngOnInit() {
    }

    move(url) {
        this.navCtrl.navigateRoot(url);
    }

    ionViewDidEnter() {
        this.platform.ready().then(dataP => {
            console.log(dataP);
            this.personService.get(this.username)
                .then(data => {
                    console.log(data);

                    const result = JSON.parse(data.data);

                    localStorage.setItem('fullname', result.fullname);
                    localStorage.setItem('age', result.age);

                    const tipoPersona = result.personType;

                    if (tipoPersona) {
                        localStorage.setItem('type', 'owner');
                        this.showOwner = true;
                    } else {
                        localStorage.setItem('type', 'tenant');
                        this.showTenant = true;
                    }
                })
                .catch(error => {
                    this.errorService.consoleLog(error);
                    this.errorService.alertError(error);
                });
        });
    }

}
