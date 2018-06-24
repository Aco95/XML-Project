import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { routing } from './app.routing';
import { FormsModule } from '@angular/forms'

import { HttpClientModule, HttpClient, } from '@angular/common/http';
import { HttpModule, Http } from '@angular/http';


import { AppComponent } from './app.component';
import { AgentHomePageComponent } from './components/agent-home-page/agent-home-page.component';

import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

import { SmestajService } from './services/smestaj.service';
import { PorukaService } from './services/poruka.service';
import { KorisnikService } from './services/korisnik.service';
import { RezervacijaService } from './services/rezervacija.service';
import { SobaService } from './services/soba.service';

// register-login
import { LoginComponent } from './components/login/login.component';
import { LoginLogoutComponent } from './components/login-logout/login-logout.component';
import { LoginService } from './services/login.service';
import { AuthServiceService } from './services/auth-service.service';
import { MyCustomHttp } from './services/my-custom-http';
import { RequestOptions, XHRBackend } from '@angular/http';
import { Router } from '@angular/router';
import { ReactiveFormsModule } from '@angular/forms';
import { AuthGuard } from './services/auth-guard.service';

// factory dependency injection
export function providerCustomHttp(backend: XHRBackend, defaultOptions: RequestOptions, auth: AuthServiceService, router: Router) {
  return new MyCustomHttp(backend, defaultOptions, auth, router);
}
@NgModule({
  declarations: [
    AppComponent,
    AgentHomePageComponent,
    LoginComponent,
    LoginLogoutComponent,
  ],
  imports: [
    BrowserModule,
    routing,
    NgbModule.forRoot(),
    HttpClientModule,
    HttpModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [SmestajService, PorukaService, KorisnikService, RezervacijaService, SobaService,
    AuthServiceService,
    LoginService,
    AuthGuard,
    {
      provide: Http,
      useFactory: providerCustomHttp,
      deps: [XHRBackend, RequestOptions, AuthServiceService, Router]
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
