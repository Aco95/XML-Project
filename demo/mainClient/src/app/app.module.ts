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

import { HomeRezervacijeComponent } from './components/home-rezervacije/home-rezervacije.component';

import { CommentsComponent } from './comments/comments.component';

// register-login
import { RegisterUserComponent } from './components/register-user/register-user.component';
import { LoginComponent } from './components/login/login.component';
import { LoginLogoutComponent } from './components/login-logout/login-logout.component';
import { LoginService } from './services/login.service';
import { AuthServiceService } from './services/auth-service.service';
import { MyCustomHttp } from './services/my-custom-http';
import { RequestOptions, XHRBackend } from '@angular/http';
import { Router } from '@angular/router';
import { ReactiveFormsModule } from '@angular/forms';

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
    RegisterUserComponent,
    LoginComponent,
    LoginLogoutComponent
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
  providers: [HttpClientModule, SearchService, LoginService, AuthServiceService,
    {
      provide: Http,
      useFactory: providerCustomHttp,
      deps: [XHRBackend, RequestOptions, AuthServiceService, Router]
    }],
  bootstrap: [AppComponent]
})
export class AppModule { }
