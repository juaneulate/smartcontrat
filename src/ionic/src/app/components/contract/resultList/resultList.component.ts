import {Component, Input, OnInit} from '@angular/core';
import {ContractModel} from '../../../models/contract.model';
import {ContractsService} from '../../../services/contracts/contracts.service';
import {ErrorService} from '../../../services/error/error.service';
import {AlertService} from '../../../services/alert/alert.service';

@Component({
    selector: 'app-resultList',
    templateUrl: './resultList.component.html',
    styleUrls: ['./resultList.component.scss'],
})
export class ResultListComponent implements OnInit {

    @Input() searchText: string;
    results: ContractModel[];

    constructor(
        private contractService: ContractsService,
        private errorService: ErrorService,
        private alertService: AlertService
    ) {
    }

    ngOnInit() {
        this.contractService.list(this.searchText)
            .then(data => {
                const auxiliar = JSON.parse(data.data);

                console.log('Buscar results: ');
                console.log(auxiliar);
                this.results = [];

                for (const httpResult of auxiliar) {
                    const contract = httpResult;
                    this.results.push(contract);
                }

            })
            .catch(error => {
                this.errorService.alertError(error);
            });
    }

}
