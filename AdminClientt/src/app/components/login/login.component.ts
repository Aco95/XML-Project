import { Component, OnInit, Inject } from '@angular/core';
import { LoginService } from '../../services/login.service';
import { Router } from '@angular/router';
import { FormBuilder, FormGroup, Validators, FormControl } from '@angular/forms';
import { AuthServiceService } from "../../services/auth-service.service";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  error: any;
  form: FormGroup;
  constructor(private loginService: LoginService, private router: Router, @Inject(FormBuilder) formBuilder: FormBuilder, private authService: AuthServiceService) {
    this.form = formBuilder.group({
      email: new FormControl("", [Validators.required, Validators.email]),
      password: new FormControl("", [Validators.required]),
    });
  }
  ngOnInit() {
  }

  onSubmit(event: any) {
    let response = this.loginService.loginUser(this.form.value)
      .subscribe((data) => {
        let redirect = this.authService.getRedirectUrl() ? this.authService.getRedirectUrl() : '/homePage';

        // Redirect the user
        this.router.navigate([redirect]);
        console.log("uspelo");
      }, error => {
        this.error = "Bad credentials"; // or extract smth from <error> object
        console.log(this.error);
      });
  }
}
