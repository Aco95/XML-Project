import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { routing } from './app.routing';


import { AppComponent } from './app.component';
import { AgentHomePageComponent } from './components/agent-home-page/agent-home-page.component';

import {NgbModule} from '@ng-bootstrap/ng-bootstrap';

import {SmestajService} from './services/smestaj.service'

@NgModule({
  declarations: [
    AppComponent,
    AgentHomePageComponent
  ],
  imports: [
    BrowserModule,
    routing,
    NgbModule.forRoot()
  ],
  providers: [SmestajService],
  bootstrap: [AppComponent]
})
export class AppModule { }
