import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { FormBuilder, FormControl, Validators } from '@angular/forms';
import { GetSmartContractOptionsService } from 'src/app/services/contracts/getSmartContractOptions/get-smart-contract-options.service';
import { RegisterSmartContractService } from 'src/app/services/contracts/registerSmartContract/register-smart-contract.service';
import { Platform } from '@ionic/angular';

@Component({
  selector: 'app-detail',
  templateUrl: './detail.page.html',
  styleUrls: ['./detail.page.scss'],
})
export class DetailPage implements OnInit {

  idContract: number;
  showDetail: boolean;
  detailForm: any = {};
  loading: boolean;
  submitted: boolean;
  registerSmartContract: RegisterSmartContractService;

  constructor(
    private route: ActivatedRoute,
    private formBuilder: FormBuilder,
    private getSmarContractOptions: GetSmartContractOptionsService,
    private platform: Platform
  ) { }

  ngOnInit() {
    this.route.queryParams.subscribe(params => {
      this.idContract = params['id'];
      this.showDetail = true;
      console.log(this.idContract);
    });

    this.registerSmartContract = new RegisterSmartContractService(this.platform);

    this.detailForm = this.formBuilder.group({
      billetera: new FormControl('', { validators: Validators.required }),
    });

    this.loading = false;
    this.submitted = false;
  }
  get f() {
    return this.detailForm.controls;
  }

  register() {
    // stop here if form is invalid
    if (this.detailForm.invalid) {
      return;
    }
    this.loading = true;
    this.submitted = true;

    const billetera = this.f.billetera.value;

    this.getSmarContractOptions.execute(this.idContract)
      .then(data => {
        const result = JSON.parse(data.data);
        const hashContract = result.hashContract;
        const jsonContract = result.jsonContract;
        console.log(result);

        this.registerSmartContract.register(billetera, jsonContract, hashContract);

        this.loading = false;
      });

  }

}
