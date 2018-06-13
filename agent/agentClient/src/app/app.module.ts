import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { routing } from './app.routing';

import { AppComponent } from './app.component';
import { AgentHomePageComponent } from './components/agent-home-page/agent-home-page.component';


@NgModule({
  declarations: [
    AppComponent,
    AgentHomePageComponent
  ],
  imports: [
    BrowserModule,
    routing
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
