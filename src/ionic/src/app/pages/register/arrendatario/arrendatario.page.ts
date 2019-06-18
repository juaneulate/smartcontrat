import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormControl, Validators} from '@angular/forms';
import {AlertController} from '@ionic/angular';
import {Router} from '@angular/router';
import {ArrendatarioService} from '../../../services/arrendatario/arrendatario.service';

@Component({
    selector: 'app-arrendatario',
    templateUrl: './arrendatario.page.html',
    styleUrls: ['./arrendatario.page.scss'],
})
export class ArrendatarioPage implements OnInit {
    formOptions: any = {};
    submitted = false;
    loading = false;
    isOk = false;
    returnUrl = '';

    constructor(
        private formBuilder: FormBuilder,
        private arrendatarioService: ArrendatarioService,
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

        this.arrendatarioService.save(lastname, age, username, password).subscribe(
            data => {
                this.isOk = data;

                if (this.isOk) {
                    return this.router.navigate([this.returnUrl]);
                } else {
                    this.message('Error al guardar usuario');
                }
            },
            error => {
                console.log(error);
                this.message(error.message);

            }
        );
    }

    async message(message, error = null) {

        if (error != null) {
            message += ' ' + error;
        }

        const alert = await this.alertCtrl.create({
            header: 'Panic!!',
            message,
            buttons: [{
                text: 'OK',
                handler: () => {
                    console.log('OK clicked');
                }
            }]
        });
        alert.present();
    }

}
