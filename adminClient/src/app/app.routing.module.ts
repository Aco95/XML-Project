
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { AgentComponent } from './agent/agent.component';
import {AddAgentComponent} from './agent/add-agent.component';

const routes: Routes = [
  { path: 'agents', component: AgentComponent },
  { path: 'add', component: AddAgentComponent }
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