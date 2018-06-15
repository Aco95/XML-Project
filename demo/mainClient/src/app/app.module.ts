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
<<<<<<< HEAD
import { HomeRezervacijeComponent } from './components/home-rezervacije/home-rezervacije.component';
=======
import { CommentsComponent } from './comments/comments.component';
>>>>>>> 5af3d19b948fdddf48a1953a7c7d74e03c1bec3f

@NgModule({
  declarations: [
    AppComponent,
    HomePageComponent,
    LoginComponent,
<<<<<<< HEAD
    HomeRezervacijeComponent
=======
    CommentsComponent
>>>>>>> 5af3d19b948fdddf48a1953a7c7d74e03c1bec3f
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
