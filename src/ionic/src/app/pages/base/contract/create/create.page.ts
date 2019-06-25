import { Component, OnInit } from '@angular/core';
import { FormControl, Validators, FormBuilder } from '@angular/forms';
import { ContractsService } from 'src/app/services/contracts/list/contracts.service';
import { ErrorService } from 'src/app/services/error/error.service';
import { NavController } from '@ionic/angular';

@Component({
  selector: 'app-create',
  templateUrl: './create.page.html',
  styleUrls: ['./create.page.scss'],
})
export class CreatePage implements OnInit {


  createForm: any = {};
  loading = false;
  submitted = false;
  returnUrl: string;

  constructor(
    private formBuilder: FormBuilder,
    private contractsService: ContractsService,
    private errorService: ErrorService,
    private navCtrl: NavController
  ) {
    this.createForm = this.formBuilder.group({
      registroBilletera: new FormControl('', { validators: Validators.required }),
      montoTotal: new FormControl('', { validators: Validators.required }),
      cuota: new FormControl('', { validators: Validators.required }),
      nombreContrato: new FormControl('', { validators: Validators.required }),
      hashContrato: new FormControl('', { validators: Validators.required }),
    });
  }

  ngOnInit() {
    this.loading = false;
    this.submitted = false;
    this.returnUrl = '/base/main/home';
  }

  get f() {
    return this.createForm.controls;
  }

  saveContract() {
    // stop here if form is invalid
    if (this.createForm.invalid) {
      return;
    }

    this.submitted = true;
    this.loading = true;

    const registroBilletera = this.f.registroBilletera.value;
    const montoTotal = this.f.montoTotal.value;
    const cuota = this.f.cuota.value;
    const nombreContrato = this.f.nombreContrato.value;
    const hashContrato = this.f.hashContrato.value;

    this.contractsService.save(registroBilletera, montoTotal, cuota, nombreContrato, hashContrato)
      .then(data => {
        console.log(data);
        this.navCtrl.navigateRoot(this.returnUrl);
      })
      .catch(error => {
        this.loading = false;
        this.errorService.alertError(error);
        this.errorService.consoleLog(error);
      });

  }
}
