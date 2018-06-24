import { ModuleWithProviders } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
import { CommentsComponent } from './components/comments/comments.component';
import { RegisterAgentComponent } from './components/register-agent/register-agent.component';
import { ManageKorisnikComponent } from "./components/manage-korisnik/manage-korisnik.component";
import { LoginComponent } from "./components/login/login.component";
import { NgModule } from '@angular/core';
import { HomePageComponent } from "./components/home-page/home-page.component";
import { EditSmestajComponent } from './components/edit-smestaj/edit-smestaj.component';


import { AuthGuard } from './services/auth-guard.service';

const appRoutes: Routes =
    [
        {
            path: '', component: HomePageComponent,
            canActivate: [AuthGuard],
        },
        { path: 'user-comments', component: CommentsComponent },
        { path: 'register-agent', component: RegisterAgentComponent },
        { path: 'manage-korisnik', component: ManageKorisnikComponent },
        { path: 'edit-smestaj', component: EditSmestajComponent },
        { path: 'login', component: LoginComponent },
        {
            path: 'homePage',
            component: HomePageComponent,
            canActivate: [AuthGuard],

        }
    ];


export const routing: ModuleWithProviders = RouterModule.forRoot(appRoutes);