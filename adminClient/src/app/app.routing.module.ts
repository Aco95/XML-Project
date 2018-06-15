
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { AgentComponent } from './agent/agent.component';
import { AddAgentComponent } from './agent/add-agent.component';
import { CommentsComponent } from './comments/comments.component';

const routes: Routes = [
  { path: 'agents', component: AgentComponent },
  { path: 'add', component: AddAgentComponent },
  { path: 'user-comments', component: CommentsComponent}
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [
    RouterModule
  ],
  declarations: []
})
export class AppRoutingModule { }