import { Component, OnInit, Inject } from '@angular/core';
import { LoginService } from '../../services/login.service';
import { Router } from '@angular/router';
import { FormBuilder, FormGroup, Validators, FormControl } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
<<<<<<< HEAD

  korisnik: Korisnik = {
	id: '1',
	ime: 'Boban',
  prezime: 'Poznanovic',
  email:'test@gmail.com',
	adresa: 'Slobodana Bajica 1/28',
	maticniBroj: '1234',
	username: 'boban',
	password: 'boban',
  uloga: 0,
  blokiran: false
  };

  constructor() { }

=======
  error: any;
  form: FormGroup;
  constructor(private loginService: LoginService, private router: Router, @Inject(FormBuilder) formBuilder: FormBuilder) {
    this.form = formBuilder.group({
      email: new FormControl("", [Validators.required, Validators.email]),
      password: new FormControl("", [Validators.required]),
    });
  }
>>>>>>> refs/remotes/origin/master
  ngOnInit() {
  }

  onSubmit(event: any) {
    let response = this.loginService.loginUser(this.form.value)
      .subscribe((next) => {
        this.router.navigateByUrl("/rezervacije"); // login succeleed\
        console.log("uspelo");
      }, error => {
        this.error = "Bad credentials"; // or extract smth from <error> object
        console.log(this.error);
      });
  }
}
