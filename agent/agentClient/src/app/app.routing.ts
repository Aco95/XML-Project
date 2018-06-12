import { ModuleWithProviders } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";

import { AgentHomePageComponent } from "./components/agent-home-page/agent-home-page.component";

const appRoutes: Routes = 
[
    {
        path: '',
        redirectTo: '/homeSearch',
        pathMatch:'full'
        //component: LoginComponent
    },

    {
        path:'homeSearch',
        component: AgentHomePageComponent
    }

]

export const routing: ModuleWithProviders = RouterModule.forRoot(appRoutes);