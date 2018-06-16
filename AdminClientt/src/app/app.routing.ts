import { ModuleWithProviders } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
import { CommentsComponent } from './components/comments/comments.component';
import { RegisterAgentComponent } from './components/register-agent/register-agent.component';

const appRoutes: Routes =
    [
        { path: 'user-comments', component: CommentsComponent },
        { path: 'register-agent', component: RegisterAgentComponent }
    ]




export const routing: ModuleWithProviders = RouterModule.forRoot(appRoutes);