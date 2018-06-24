import { ModuleWithProviders } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";

import { AgentHomePageComponent } from "./components/agent-home-page/agent-home-page.component";
import { LoginComponent } from "./components/login/login.component";
import { AuthGuard } from './services/auth-guard.service';

const appRoutes: Routes =
    [
        {
            path: '',
            redirectTo: '/homeSearch',
            pathMatch: 'full'
            //component: LoginComponent
        },
        {
            path: 'homeSearch',
            component: AgentHomePageComponent,
            canActivate: [AuthGuard],

        },
        {
            path: 'login',
            component: LoginComponent
        }

    ]

export const routing: ModuleWithProviders = RouterModule.forRoot(appRoutes);