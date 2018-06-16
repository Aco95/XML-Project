import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { routing } from './app.routing';


import { AppComponent } from './app.component';
import { HomePageComponent } from './components/home-page/home-page.component';
import { CommentsComponent } from './components/comments/comments.component';
import { BlockKorisnikComponent } from './components/block-korisnik/block-korisnik.component';
import { RegisterAgentComponent } from './components/register-agent/register-agent.component';


@NgModule({
  declarations: [
    AppComponent,
    HomePageComponent,
    CommentsComponent,
    BlockKorisnikComponent,
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
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
