import { ModuleWithProviders } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";

import { HomePageComponent } from "./components/home-page/home-page.component";


const appRoutes: Routes = 
[
    {
        path: '',
        redirectTo: '/homeSearch',
        pathMatch:'full'
    
    },

    {
        path:'homeSearch',
        component: HomePageComponent
    }

]




export const routing: ModuleWithProviders = RouterModule.forRoot(appRoutes);