import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Korisnik } from '../model/Korisnik';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class UserService {

  private backUrl = 'http://localhost:8080/users/';

  private data: Korisnik;
  private retVal: Observable<Boolean>;
  private vracenKorisnik;

  constructor(private http: HttpClient) { }

  register(korisnik: Korisnik){

    console.log('Registracija');

    this.data = korisnik;


    return this.http.post(this.backUrl+'register', this.data)
  }

  

}