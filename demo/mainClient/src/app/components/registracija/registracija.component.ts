import { Component, OnInit } from '@angular/core';
import { UserService } from '../../services/user.service';
import { Korisnik } from '../../model/Korisnik';
import { Uloga } from '../../model/Uloga.enum';
import { FormBuilder, Validators, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-registracija',
  templateUrl: './registracija.component.html',
  styleUrls: ['./registracija.component.css']
})
export class RegistracijaComponent implements OnInit {

	noviKorisnik: Korisnik = {
		id:'1', ime:'TestBoban', prezime:'TestPoznanovic',adresa:'TestNS', blokiran: false, maticniBroj:'1234', 
		password:'sifra', uloga: Uloga.USER, username:'boban', email:'test@gmail.com'
	};
	checkPass = "sifra";

	constructor(private userService: UserService, private router: Router) { }

	//TODO remove
	get diagnostic() { return JSON.stringify(this.noviKorisnik);}

	ngOnInit(){
	}

	register() {

		console.log(this.noviKorisnik);
		
		
		this.userService.register(this.noviKorisnik);
		
		
	}

}
