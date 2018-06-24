import { Component, OnInit } from '@angular/core';
import { UserService } from '../../services/user.service';
import { Korisnik } from '../../model/Korisnik';
import { Uloga } from '../../model/Uloga.enum';
import { FormBuilder, Validators, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { Observable } from 'rxjs/Observable';

@Component({
  selector: 'app-registracija',
  templateUrl: './registracija.component.html',
  styleUrls: ['./registracija.component.css']
})
export class RegistracijaComponent implements OnInit {

	startKorisnik: Korisnik = {
		id:'1', ime:'Enter Your first name', prezime:'Enter Your last name',adresa:'Enter your address', blokiran: false, 
		maticniBroj:'Enter Your personal numbers', 
		password:'Enter Your password', uloga: Uloga.USER, username:'Choose Your username', email:'Enter Your email address'
	}

	noviKorisnik: Korisnik = {
		id:'1', ime:'Enter Your first name', prezime:'Enter Your last name',adresa:'Enter your address', blokiran: false, 
		maticniBroj:'Enter Your personal numbers', 
		password:'Enter Your password', uloga: Uloga.USER, username:'Choose Your username', email:'Enter Your email address'
	};

	vracenKorisnik: Korisnik;
	checkPass = "Enter Your password";
	emailStatus = true;
	passwordStatus = true;
	uspesnaRegistracija: boolean
	constructor(private userService: UserService, private router: Router) { }

	//TODO remove
	get diagnostic() { return JSON.stringify(this.noviKorisnik);}

	ngOnInit(){
	}

	getEmailStatus() {
		return this.emailStatus;
	}

	getPasswordStatus() {
		return this.passwordStatus;
	}

	register() {

	console.log(this.noviKorisnik);

	if(this.noviKorisnik.password===this.checkPass) {
		this.userService.register(this.noviKorisnik).subscribe(
			(data) => {
				console.log(data);
				if(data['id']==='-1') {
					this.emailStatus = false;
				}
				else {
					this.noviKorisnik = this.startKorisnik
				}
				
			}
		);
	}
	else {
		this.passwordStatus = false;
	}
		
	
		
	}

}
