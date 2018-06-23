import { ModuleWithProviders } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";

import { HomePageComponent } from "./components/home-page/home-page.component";
import { LoginComponent } from "./components/login/login.component";
import { HomeRezervacijeComponent } from "./components/home-rezervacije/home-rezervacije.component";
import { RegistracijaComponent } from "./components/registracija/registracija.component";
import { ReserveAccommodationComponent } from './components/reserve-accommodation/reserve-accommodation.component';
import { RecenzijaComponent } from './components/recenzija/recenzija.component';
import { SendMessageComponent } from './components/send-message/send-message.component';
import { MessagesComponent } from './components/messages/messages.component';

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
    },

    {
        path:'create-recenzija',
        component: RecenzijaComponent
    },

    {
        path: 'send-message',
        component: SendMessageComponent
    },

    {
        path: 'messages',
        component: MessagesComponent
    }

    ]




export const routing: ModuleWithProviders = RouterModule.forRoot(appRoutes);