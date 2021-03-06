import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { routing } from './app.routing';

import { HttpClientModule, HttpClient } from '@angular/common/http';
import { HttpModule, Http } from '@angular/http';
import { FormsModule } from '@angular/forms'
import { NgbModal, NgbModule } from '@ng-bootstrap/ng-bootstrap';

import { AppComponent } from './app.component';
import { HomePageComponent } from "./components/home-page/home-page.component";


import { SearchService } from "./services/search.service";
import { RezervacijeService } from './services/rezervacije.service';
import { UserService } from './services/user.service';

import { HomeRezervacijeComponent } from './components/home-rezervacije/home-rezervacije.component';

import { CommentsComponent } from './components/comments/comments.component';
import { RegistracijaComponent } from './components/registracija/registracija.component';
import { ReserveAccommodationComponent } from './components/reserve-accommodation/reserve-accommodation.component';

// register-login
import { LoginComponent } from './components/login/login.component';
import { LoginLogoutComponent } from './components/login-logout/login-logout.component';
import { LoginService } from './services/login.service';
import { AuthServiceService } from './services/auth-service.service';
import { MyCustomHttp } from './services/my-custom-http';
import { RequestOptions, XHRBackend } from '@angular/http';
import { Router } from '@angular/router';
import { ReactiveFormsModule } from '@angular/forms';
import { RecenzijaComponent } from './components/recenzija/recenzija.component';
import { RecenzijaService } from './services/recenzija-service';
import { SendMessageComponent } from './components/send-message/send-message.component';
import { MessagesComponent } from './components/messages/messages.component';
import { CommentsService } from './services/comments-service';

// factory dependency injection
export function providerCustomHttp(backend: XHRBackend, defaultOptions: RequestOptions, auth: AuthServiceService, router: Router) {
  return new MyCustomHttp(backend, defaultOptions, auth, router);
}
@NgModule({
  declarations: [
    AppComponent,
    HomePageComponent,
    HomeRezervacijeComponent,
    CommentsComponent,
    LoginComponent,
    LoginLogoutComponent,
    HomeRezervacijeComponent,
    CommentsComponent,
    RegistracijaComponent,
    ReserveAccommodationComponent,
    RecenzijaComponent,
    SendMessageComponent,
    MessagesComponent
  ],
  imports: [
    BrowserModule,
    routing,
    HttpClientModule,
    HttpModule,
    NgbModule.forRoot(),
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [HttpClientModule,CommentsService ,SearchService, RezervacijeService, UserService, LoginService, RecenzijaService, AuthServiceService,
    {
      provide: Http,
      useFactory: providerCustomHttp,
      deps: [XHRBackend, RequestOptions, AuthServiceService, Router]
    }],
  bootstrap: [AppComponent]
})
export class AppModule { }
