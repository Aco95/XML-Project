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

    this.data = {
      'id': '1',
      'ime': korisnik.ime,
      'prezime': korisnik.prezime,
      'uloga': korisnik.uloga,
      'username': korisnik.username,
      'password': korisnik.password,
      'maticniBroj': korisnik.maticniBroj,
      'adresa': korisnik.adresa,
      'blokiran': korisnik.blokiran,
      'email': korisnik.email
    };
    
    this.http.post<Korisnik>(this.backUrl+'register', this.data).subscribe(
      data => {
        console.log(data);
      }
    )

  }

}
