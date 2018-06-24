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

  emailChoosed = false;
  emailExist = false;
  error: any;
  form: FormGroup;
  constructor(private loginService: LoginService, private router: Router, @Inject(FormBuilder) formBuilder: FormBuilder) {
    this.form = formBuilder.group({
      email: new FormControl("", [Validators.required, Validators.email]),
      password: new FormControl("", [Validators.required]),
    });
  }
  ngOnInit() {
  }

  login(event: any) {

    let response = this.loginService.loginUser(this.form.value)
      .subscribe((next) => {
        this.router.navigateByUrl("/"); // login succeleed\
        console.log("uspelo");
      }, error => {
        this.error = "Bad credentials"; // or extract smth from <error> object
        console.log(this.error);
      });
  }

  onSubmit(event: any) {
    let response = this.loginService.checkAccount(this.form.value.email)
      .subscribe((next) => {
        if (next) {
          this.login(event);

          // this.router.navigateByUrl("/"); // login succeleed\
          // this.emailExist = next;
          // console.log("uspelo: " + next);
        }
      }, error => {
        this.error = "No such mail";
        console.log(this.error);
      });
  }
}