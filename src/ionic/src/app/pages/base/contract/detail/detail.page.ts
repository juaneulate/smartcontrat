import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { FormBuilder, FormControl, Validators } from '@angular/forms';
import { GetSmartContractOptionsService } from 'src/app/services/contracts/getSmartContractOptions/get-smart-contract-options.service';
import { RegisterSmartContractService } from 'src/app/services/contracts/registerSmartContract/register-smart-contract.service';
import { Platform } from '@ionic/angular';
import { ContractsService } from 'src/app/services/contracts/list/contracts.service';
import { ContractModel } from 'src/app/models/contract.model';

@Component({
  selector: 'app-detail',
  templateUrl: './detail.page.html',
  styleUrls: ['./detail.page.scss'],
})
export class DetailPage implements OnInit {

  idContract: number;
  contract: ContractModel;
  showDetail: boolean;
  detailForm: any = {};
  loading: boolean;
  submitted: boolean;
  registerSmartContract: RegisterSmartContractService;
  personType: any;

  constructor(
    private route: ActivatedRoute,
    private formBuilder: FormBuilder,
    private getSmarContractOptions: GetSmartContractOptionsService,
    private contractsService: ContractsService,
    private platform: Platform
  ) { }

  ngOnInit() {
    this.route.queryParams.subscribe(params => {
      this.idContract = params['id'];
      console.log(this.idContract);
      this.platform.ready().then(dataP => {
        this.contractsService.get(this.idContract).then(data => {
          this.contract = JSON.parse(data.data);
          console.log('Contrato: ');
          console.log(this.contract);
          this.showDetail = true;
        });
      });
    });

    this.registerSmartContract = new RegisterSmartContractService(this.platform);

    this.detailForm = this.formBuilder.group({
      billetera: new FormControl('', { validators: Validators.required }),
      fullName: new FormControl('', { validators: Validators.required }),
      age: new FormControl('', { validators: Validators.required }),
      personType: new FormControl('', {}),
    });

    this.loading = false;
    this.submitted = false;
  }
  get f() {
    return this.detailForm.controls;
  }

  register() {
    // stop here if form is invalid
    this.submitted = true;
    if (this.detailForm.invalid) {
      return;
    }
    console.log('form is valid');
    this.loading = true;

    const billetera = this.f.billetera.value;
    const name = this.f.fullName.value;
    const age = this.f.age.value;
    const personType = this.f.personType.value === 'true';

    this.getSmarContractOptions.execute(this.idContract)
      .then(data => {
        const result = JSON.parse(data.data);
        const hashContract = result.hashContract;
        const jsonContract = result.jsonContract;
        console.log(result);

        this.registerSmartContract.register(billetera, jsonContract, hashContract, name, age, personType);

        this.loading = false;
      });

  }

}
