import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { RouterModule, Routes } from '@angular/router';

import { IonicModule } from '@ionic/angular';

import { BasePage } from './base.page';
import { AuthGuard } from '../../../auths/auth.guard';

const routes: Routes = [
    {
        path: 'main',
        children: [
            { path: 'home', loadChildren: '../home/search/search.module#SearchPageModule', canActivate: [AuthGuard] },
            { path: 'list', loadChildren: '../list/list.module#ListPageModule' },
            { path: 'contract/create', loadChildren: '../contract/create/create.module#CreatePageModule' },
            { path: 'contract/detail', loadChildren: '../contract/detail/detail.module#DetailPageModule' }

        ],
        component: BasePage
    },
    {
        path: '',
        redirectTo: 'main/home',
        pathMatch: 'full'
    }
];

@NgModule({
    imports: [
        CommonModule,
        FormsModule,
        IonicModule,
        RouterModule.forChild(routes)
    ],
    declarations: [BasePage]
})
export class BasePageModule {
}
