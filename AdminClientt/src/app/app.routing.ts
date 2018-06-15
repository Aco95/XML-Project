import { ModuleWithProviders } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
import { CommentsComponent } from './components/comments/comments.component';

const appRoutes: Routes = 
[
    { path: 'user-comments', component: CommentsComponent}
]




export const routing: ModuleWithProviders = RouterModule.forRoot(appRoutes);