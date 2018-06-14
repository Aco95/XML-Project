import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { AgentComponent } from './agent/agent.component';
import { AddAgentComponent } from './agent/add-agent.component';
import { AppRoutingModule } from './app.routing.module';
import { HttpClientModule } from '@angular/common/http';
import { AgentService } from './agent/agent.service';

@NgModule({
  declarations: [
    AppComponent,
    AgentComponent,
    AddAgentComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [AgentService],
  bootstrap: [AppComponent]
})
export class AppModule { }
