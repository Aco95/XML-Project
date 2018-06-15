import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { routing } from './app.routing';

import { HttpClientModule, HttpClient} from '@angular/common/http';
import { HttpModule, Http } from '@angular/http';
import { FormsModule} from '@angular/forms'
import { NgbModal, NgbModule } from '@ng-bootstrap/ng-bootstrap';

import { AppComponent } from './app.component';
import { HomePageComponent } from "./components/home-page/home-page.component";


import { SearchService } from "./services/search.service";
import { LoginComponent } from './components/login/login.component';

import { HomeRezervacijeComponent } from './components/home-rezervacije/home-rezervacije.component';

import { CommentsComponent } from './comments/comments.component';


@NgModule({
  declarations: [
    AppComponent,
    HomePageComponent,
    LoginComponent,
    HomeRezervacijeComponent,
    CommentsComponent
  ],
  imports: [
    BrowserModule,
    routing,
    HttpClientModule,
    HttpModule,
    NgbModule.forRoot(),
    FormsModule
  ],
  providers: [HttpClientModule, SearchService],
  bootstrap: [AppComponent]
})
export class AppModule { }
