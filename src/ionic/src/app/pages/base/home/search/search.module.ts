import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, FormControl, ReactiveFormsModule } from '@angular/forms';
import { Routes, RouterModule } from '@angular/router';

import { IonicModule } from '@ionic/angular';

import { SearchPage } from './search.page';
import { ResultListComponent } from 'src/app/components/contract/resultList/resultList.component';

const routes: Routes = [
  {
    path: 'contract/detail', loadChildren: '../../contract/detail/detail.module#DetailPageModule'
  },
  {
    path: '',
    component: SearchPage
  }
];

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    ReactiveFormsModule,
    RouterModule.forChild(routes)
  ],
  declarations: [SearchPage, ResultListComponent]
})
export class SearchPageModule { }
