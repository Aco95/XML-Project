import { ModuleWithProviders } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";

import { HomePageComponent } from "./components/home-page/home-page.component";
import { LoginComponent } from "./components/login/login.component";
import { RegisterUserComponent } from "./components/register-user/register-user.component";

import { HomeRezervacijeComponent } from "./components/home-rezervacije/home-rezervacije.component";


const appRoutes: Routes =
    [
        {
            path: '',
            redirectTo: '/homeSearch',
            pathMatch: 'full'

        },

        {
            path: 'homeSearch',
            component: HomePageComponent
        },

        {
            path: 'login',
            component: LoginComponent
        },
        {
            path: 'rezervacije',
            component: HomeRezervacijeComponent
        },
        {
            path: 'register',
            component: RegisterUserComponent
        },

    ]




export const routing: ModuleWithProviders = RouterModule.forRoot(appRoutes);