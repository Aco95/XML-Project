import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { routing } from './app.routing';
import { FormsModule} from '@angular/forms'

import { HttpClientModule, HttpClient,} from '@angular/common/http';
import { HttpModule,Http } from '@angular/http';


import { AppComponent } from './app.component';
import { AgentHomePageComponent } from './components/agent-home-page/agent-home-page.component';

import {NgbModule} from '@ng-bootstrap/ng-bootstrap';

import {SmestajService} from './services/smestaj.service';
import {PorukaService} from './services/poruka.service';
import {KorisnikService} from './services/korisnik.service';
import {RezervacijaService} from './services/rezervacija.service';
import {SobaService} from './services/soba.service';


@NgModule({
  declarations: [
    AppComponent,
    AgentHomePageComponent
  ],
  imports: [
    BrowserModule,
    routing,
    NgbModule.forRoot(),
    HttpClientModule,
    HttpModule,
    FormsModule
  ],
  providers: [SmestajService, PorukaService, KorisnikService, RezervacijaService, SobaService],
  bootstrap: [AppComponent]
})
export class AppModule { }
