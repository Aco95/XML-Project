import { ModuleWithProviders } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
import { CommentsComponent } from './components/comments/comments.component';
import { RegisterAgentComponent } from './components/register-agent/register-agent.component';
import { ManageKorisnikComponent } from "./components/manage-korisnik/manage-korisnik.component";

const appRoutes: Routes =
    [
        { path: 'user-comments', component: CommentsComponent },
        { path: 'register-agent', component: RegisterAgentComponent },
        { path: 'manage-korisnik', component: ManageKorisnikComponent }

    ]




export const routing: ModuleWithProviders = RouterModule.forRoot(appRoutes);