import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {IonicModule} from '@ionic/angular';
import {RouterModule} from '@angular/router';

import {HomePage} from './home.page';
import {ResultListComponent} from '../../../components/contract/resultList/resultList.component';

@NgModule({
    imports: [
        CommonModule,
        FormsModule,
        IonicModule,
        RouterModule.forChild([
            {path: '', component: HomePage}
        ]),
        ReactiveFormsModule
    ],
    declarations: [HomePage, ResultListComponent]
})
export class HomePageModule {
}
