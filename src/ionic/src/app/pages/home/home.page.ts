import {Component, OnInit} from '@angular/core';
import {PersonService} from '../../services/person/person.service';
import {ErrorService} from '../../services/error/error.service';
import {AlertService} from '../../services/alert/alert.service';
import {FormControl} from '@angular/forms';
import {ContractsService} from '../../services/contracts/contracts.service';
import {ContractModel} from '../../models/contract.model';

@Component({
    selector: 'app-home',
    templateUrl: 'home.page.html',
    styleUrls: ['home.page.scss'],
})
export class HomePage implements OnInit {
    username: string;
    searchControl: FormControl;
    showResults = true;
    result: ContractModel[];

    constructor(
        private personService: PersonService,
        private errorService: ErrorService,
        private contractService: ContractsService,
        private alertService: AlertService
    ) {
        this.username = localStorage.getItem('token');
    }

    ngOnInit() {
        this.searchControl = new FormControl();
        this.personService.get(this.username).subscribe(
            data => {
                console.log(data);
                localStorage.setItem('fullname', data.lastname);
                localStorage.setItem('age', data.age.toString());
                if (data.tipoPersona) {
                    localStorage.setItem('type', 'owner');
                } else {
                    localStorage.setItem('type', 'lessee');
                }

            },
            error => {
                this.errorService.consoleLog(error);
                this.errorService.alertError(error);
            }
        );
    }

    onInput() {
        const login = this.searchControl.value;
        this.contractService.list(login).subscribe(
            data => {
                console.log(data);
                this.result = data;
            },
            error => {
                this.errorService.alertError(error);
            }
        );
    }
}
