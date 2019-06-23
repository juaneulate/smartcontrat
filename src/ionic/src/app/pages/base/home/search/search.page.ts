import { Component, OnInit } from '@angular/core';
import { FormControl } from '@angular/forms';
import { ErrorService } from 'src/app/services/error/error.service';
import { AlertService } from 'src/app/services/alert/alert.service';
import { ContractModel } from 'src/app/models/contract.model';
import { ContractsService } from 'src/app/services/contracts/list/contracts.service';

@Component({
  selector: 'app-search',
  templateUrl: './search.page.html',
  styleUrls: ['./search.page.scss'],
})
export class SearchPage implements OnInit {

  username: string;
  searchControl: FormControl;
  showResults = false;
  searchText: string;
  results: ContractModel[];
  constructor(
    private contractService: ContractsService,
    private errorService: ErrorService,
    private alertService: AlertService
  ) { }

  ngOnInit() {
    this.searchControl = new FormControl();
    this.searchText = 'juancho';
  }

  onChange() {
    this.showResults = false;

    const login = this.searchControl.value;
    console.log(login);
    if (login != null) {
      this.searchText = login;
      this.contractService.list(this.searchText)
        .then(data => {
          const contracts = JSON.parse(data.data);
          console.log('Buscar results: ');
          console.log(contracts);
          this.results = [];
          for (const contract of contracts) {
            this.results.push(contract);
          }
          this.showResults = true;

        })
        .catch(error => {
          this.errorService.alertError(error);
        });
    }
  }

}
