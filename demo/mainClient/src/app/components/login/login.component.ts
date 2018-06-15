import { Component, OnInit } from '@angular/core';
import { Korisnik } from '../../model/Korisnik';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  korisnik: Korisnik = {
	id: '1',
	ime: 'Boban',
	prezime: 'Poznanovic',
	adresa: 'Slobodana Bajica 1/28',
	maticniBroj: '1234',
	username: 'boban',
	password: 'boban',
  uloga: 0,
  blokiran: false
  };

  constructor() { }

  ngOnInit() {
  }

}
