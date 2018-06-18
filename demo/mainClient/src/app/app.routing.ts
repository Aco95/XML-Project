import { ModuleWithProviders } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";

import { HomePageComponent } from "./components/home-page/home-page.component";
import { LoginComponent } from "./components/login/login.component";
import { HomeRezervacijeComponent } from "./components/home-rezervacije/home-rezervacije.component";
import { RegistracijaComponent } from "./components/registracija/registracija.component";
import { ReserveAccommodationComponent } from './components/reserve-accommodation/reserve-accommodation.component';

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
        component: RegistracijaComponent
    },

    {
        path:'reserveAccommodation',
        component: ReserveAccommodationComponent
    }

    ]




export const routing: ModuleWithProviders = RouterModule.forRoot(appRoutes);