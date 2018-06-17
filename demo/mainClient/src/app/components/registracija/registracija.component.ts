import { Component, OnInit } from '@angular/core';
import { UserService } from '../../services/user.service';
import { Korisnik } from '../../model/Korisnik';
import { Uloga } from '../../model/Uloga.enum';

@Component({
  selector: 'app-registracija',
  templateUrl: './registracija.component.html',
  styleUrls: ['./registracija.component.css']
})
export class RegistracijaComponent implements OnInit {

  noviKorisnik: Korisnik = {
    id:'1', ime:'', prezime:'',adresa:'', blokiran: false, maticniBroj:'', password:'', uloga: Uloga.USER, username:''
  };
  checkPass = "";

  constructor(private userService: UserService) { }

  ngOnInit() {
  }

  register(ime: string, prezime: string, username: string, password: string, repassword: string, jmbg: string
  , adresa: string) {
    this.noviKorisnik.ime = ime;
    this.noviKorisnik.prezime = prezime;
    this.noviKorisnik.username = username;
    this.noviKorisnik.password = password;
    this.noviKorisnik.maticniBroj = jmbg;
    this.noviKorisnik.adresa = adresa;
    
    this.userService.register(this.noviKorisnik);
  }

}
