import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { routing } from './app.routing';

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

@NgModule({
  declarations: [
    AppComponent,
    HomePageComponent,
    CommentsComponent,
    ManageKorisnikComponent,
    RegisterAgentComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    routing,
    NgbModule.forRoot()
  ],
  providers: [RegisterAgentService, ManageKorisnikService, CommentService],
  bootstrap: [AppComponent]
})
export class AppModule { }
