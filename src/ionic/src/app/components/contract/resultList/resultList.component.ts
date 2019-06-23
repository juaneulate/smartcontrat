import { Component, Input, OnInit } from '@angular/core';
import { ContractModel } from '../../../models/contract.model';
import { ErrorService } from '../../../services/error/error.service';
import { AlertService } from '../../../services/alert/alert.service';
import { of, Observable } from 'rxjs';
import { Platform, NavController } from '@ionic/angular';
import { Navigation } from 'selenium-webdriver';
import { NavigationOptions } from '@ionic/angular/dist/providers/nav-controller';

@Component({
    selector: 'app-resultList',
    templateUrl: './resultList.component.html',
    styleUrls: ['./resultList.component.scss'],
})
export class ResultListComponent implements OnInit {

    @Input() results: ContractModel[];

    private detailUrl: string;
    constructor(
        private navCtrl: NavController
    ) {
        if (this.results === undefined) {
            this.results = [];
        }
        console.log(this.results);
    }

    ngOnInit() {
       this.detailUrl = '/base/main/home/contract/detail';
    }

    redirect(idContract: number) {
        let navOptions: NavigationOptions = {
            queryParams: { id: JSON.stringify(idContract) }
        };

        this.navCtrl.navigateForward(this.detailUrl, navOptions);
    }
}
