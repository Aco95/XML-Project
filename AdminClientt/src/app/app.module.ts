import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { routing } from './app.routing';
import { Router } from '@angular/router';

//************KOMPONENTE**************** 
import { AppComponent } from './app.component';
import { HomePageComponent } from './components/home-page/home-page.component';
import { CommentsComponent } from './components/comments/comments.component';
import { ManageKorisnikComponent } from './components/manage-korisnik/manage-korisnik.component';
import { RegisterAgentComponent } from './components/register-agent/register-agent.component';

// ***********SERVISI**********
import { RegisterAgentService } from './services/register-agent.service';
import { ManageKorisnikService } from './services/manage-korisnik.service';
import { CommentService } from './services/comment-service';

// register-login
import { LoginComponent } from './components/login/login.component';
import { LoginLogoutComponent } from './components/login-logout/login-logout.component';
import { LoginService } from './services/login.service';
import { AuthServiceService } from './services/auth-service.service';
import { HTTP_INTERCEPTORS } from '@angular/common/http';
import { TokenInterceptor } from './app.module';
export { TokenInterceptor } from './services/token-interceptor';



@NgModule({
  declarations: [
    AppComponent,
    HomePageComponent,
    CommentsComponent,
    ManageKorisnikComponent,
    RegisterAgentComponent,
    LoginComponent,
    LoginLogoutComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    routing,
    NgbModule.forRoot()
  ],
  providers: [RegisterAgentService, ManageKorisnikService, CommentService, AuthServiceService, LoginService,
    { provide: HTTP_INTERCEPTORS, useClass: TokenInterceptor, multi: true },

  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
