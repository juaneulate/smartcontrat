import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormControl, Validators} from '@angular/forms';
import {ActivatedRoute, Router} from '@angular/router';
import {LoginService} from '../../../services/login/login.service';
import {AlertController} from '@ionic/angular';

@Component({
    selector: 'app-login',
    templateUrl: './login.page.html',
    styleUrls: ['./login.page.scss'],
})
export class LoginPage implements OnInit {

    constructor(
        private authenticationService: LoginService,
        private formBuilder: FormBuilder,
        private route: ActivatedRoute,
        private router: Router,
        private alertCtrl: AlertController
    ) {
        this.loginForm = this.formBuilder.group({
            username: new FormControl('', {validators: Validators.required}),
            password: new FormControl('', {validators: Validators.required}),
        });
    }

    get f() {
        return this.loginForm.controls;
    }

    loginForm: any = {};
    loading = false;
    submitted = false;
    returnUrl: string;
    isAuth: boolean;

    ngOnInit() {
        // reset login status
        this.authenticationService.logout();
        this.loading = false;
        this.submitted = false;
        // get return url from route parameters or default to '/'
        this.returnUrl = this.route.snapshot.queryParams.returnUrl || '/';
    }

    async presentConfirm(message, error = null) {

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

    onLogin() {

        // stop here if form is invalid
        if (this.loginForm.invalid) {
            return;
        }

        this.submitted = true;
        this.loading = true;
        const username = this.f.username.value;
        const password = this.f.password.value;

        this.authenticationService.login(username, password)
            .subscribe(
                data => {
                    this.isAuth = data;
                    if (this.isAuth) {
                        console.log('Login successful');
                        localStorage.setItem('isLoggedIn', 'true');
                        localStorage.setItem('token', this.f.username.value);
                        return this.router.navigate([this.returnUrl]);
                    } else {
                        console.log('service auth is not ok.');
                        this.presentConfirm('Usuario o contraseña invalida');
                        this.loading = false;
                    }
                },
                error => {
                    this.loading = false;
                    this.presentConfirm(error.message, error.error);
                    console.log(error);
                }
            );
    }

}
