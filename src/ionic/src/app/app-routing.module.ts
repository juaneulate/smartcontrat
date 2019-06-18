import {NgModule} from '@angular/core';
import {PreloadAllModules, RouterModule, Routes} from '@angular/router';
import {AuthGuard} from './auths/auth.guard';

const routes: Routes = [
    {path: '', redirectTo: 'home', pathMatch: 'full'},
    {path: 'home', loadChildren: './home/home.module#HomePageModule', canActivate: [AuthGuard]},
    {path: 'list', loadChildren: './list/list.module#ListPageModule'},
    {path: 'login', loadChildren: './pages/auth/login/login.module#LoginPageModule'},
    {path: 'register/propietario', loadChildren: './pages/register/propietario/propietario.module#PropietarioPageModule'},
    {path: 'register/arrendatario', loadChildren: './pages/register/arrendatario/arrendatario.module#ArrendatarioPageModule'}


];

@NgModule({
    imports: [
        RouterModule.forRoot(routes, {preloadingStrategy: PreloadAllModules})
    ],
    exports: [RouterModule]
})
export class AppRoutingModule {
}
