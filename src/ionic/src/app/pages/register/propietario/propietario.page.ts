import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormControl, Validators} from '@angular/forms';
import {PropietarioService} from '../../../services/propietario/propietario.service';
import {AlertController} from '@ionic/angular';
import {Router} from '@angular/router';
import {ErrorService} from '../../../services/error/error.service';
import {AlertService} from '../../../services/alert/alert.service';

@Component({
    selector: 'app-propietario',
    templateUrl: './propietario.page.html',
    styleUrls: ['./propietario.page.scss'],
})
export class PropietarioPage implements OnInit {

    formOptions: any = {};
    submitted = false;
    loading = false;
    isOk = false;
    returnUrl = '';

    constructor(
        private formBuilder: FormBuilder,
        private errorService: ErrorService,
        private alertService: AlertService,
        private propietarioService: PropietarioService,
        private alertCtrl: AlertController,
        private router: Router
    ) {
        this.formOptions = this.formBuilder.group({
            lastname: new FormControl('', {validators: Validators.required}),
            age: new FormControl('', {validators: Validators.required}),
            username: new FormControl('', {validators: Validators.required}),
            password: new FormControl('', {validators: Validators.required}),
        });
    }

    get f() {
        return this.formOptions.controls;
    }

    ngOnInit() {
        this.loading = false;
        this.submitted = false;
        this.returnUrl = '/login';
    }

    save() {
        // stop here if form is invalid
        if (this.formOptions.invalid) {
            return;
        }

        this.submitted = true;
        this.loading = true;

        const lastname = this.f.lastname.value;
        const age = this.f.age.value;
        const username = this.f.username.value;
        const password = this.f.password.value;

        this.propietarioService.save(lastname, age, username, password)
            .then(data => {
                this.isOk = data.data;
                if (this.isOk) {
                    return this.router.navigate([this.returnUrl]);
                } else {
                    this.alertService.presentConfirm('Error al guardar usuario');
                }
            })
            .catch(error => {
                console.log(error);
                this.errorService.alertError(error);
                this.errorService.consoleLog(error);
            });
    }


}
