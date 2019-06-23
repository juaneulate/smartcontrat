import {NgModule} from '@angular/core';
import {PreloadAllModules, RouterModule, Routes} from '@angular/router';

const routes: Routes = [
    {path: '', redirectTo: 'base', pathMatch: 'full'},
    {path: 'base', loadChildren: './pages/base/base/base.module#BasePageModule'},
    {path: 'login', loadChildren: './pages/auth/login/login.module#LoginPageModule', },
    {path: 'register/propietario', loadChildren: './pages/register/propietario/propietario.module#PropietarioPageModule'},
    {path: 'register/arrendatario', loadChildren: './pages/register/arrendatario/arrendatario.module#ArrendatarioPageModule'},
];

@NgModule({
    imports: [
        RouterModule.forRoot(routes, {preloadingStrategy: PreloadAllModules})
    ],
    exports: [RouterModule]
})
export class AppRoutingModule {
}
