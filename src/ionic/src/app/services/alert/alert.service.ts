import {Injectable} from '@angular/core';
import {AlertController} from '@ionic/angular';

@Injectable({
    providedIn: 'root'
})
export class AlertService {

    constructor(
        private alertCtrl: AlertController
    ) {
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
}
