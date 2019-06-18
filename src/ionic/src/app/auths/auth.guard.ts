import {Injectable} from '@angular/core';
import {ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot} from '@angular/router';

@Injectable({
    providedIn: 'root'
})
export class AuthGuard implements CanActivate {

    constructor(
        private router: Router
    ) {

    }

    url: string;

    canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean {
        this.url = state.url;
        return this.verifyLogin(this.url);
    }

    verifyLogin(url): boolean {
        if (!this.isLoggedIn()) {
            this.router.navigate(['/login']);
            return false;
        } else if (this.isLoggedIn()) {
            return true;
        }
    }

    public isLoggedIn(): boolean {
        let status = false;
        if (localStorage.getItem('isLoggedIn') === 'true') {
            status = true;
        } else {
            status = false;
        }
        return status;
    }
}
