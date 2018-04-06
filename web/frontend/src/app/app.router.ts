import { Routes, RouterModule } from '@angular/router';

import { LoginComponent } from './feature/login/login.component';

export const routes: Routes = [
    { path : 'loginComponent', component : LoginComponent }
];

export const routing = RouterModule.forRoot(routes);