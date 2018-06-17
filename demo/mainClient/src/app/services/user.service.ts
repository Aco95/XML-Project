import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Korisnik } from '../model/Korisnik';

@Injectable()
export class UserService {

  private backUrl = 'http://localhost:8080/users/';

  private data = {};

  constructor(private http: HttpClient) { }

  register(korisnik: Korisnik) {

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
      'blokiran': korisnik.blokiran
    };
    
    this.http.post<Korisnik>(this.backUrl+'register', this.data).subscribe(
      data => {
        console.log(data);
      }
    )
    
    /*
    Dobijanje podataka sa backend-a
    Int se dobro prosledjuje
    
    console.log('Primljen user: '+korisnik.username);
    
    this.http.get(this.backUrl+'test').subscribe(
      data => {
        console.log(data);
      }
    )
    */
  }

}
