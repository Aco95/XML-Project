import { Component, OnInit } from '@angular/core';
import { AuthServiceService } from '../../services/auth-service.service';

@Component({
  selector: 'app-login-logout',
  templateUrl: './login-logout.component.html',
  styleUrls: ['./login-logout.component.css']
})
export class LoginLogoutComponent implements OnInit {

  helpStorage = localStorage;
  private loggedUser: any;
  constructor(private authService: AuthServiceService) {
  }

  ngOnInit() {
    this.loggedUser = this.authService.getUser();
    console.log("logovani user" + JSON.stringify(this.loggedUser));
  }

  clickLogout() {
    this.authService.logoutUser();
  }
  usernameLoged(): String {
    return (JSON.parse(this.helpStorage.getItem('user'))).ime;
  }
}
