import { Injectable } from '@angular/core';

import { Observable, Subject, asapScheduler, pipe, of, from, interval, merge, fromEvent } from 'rxjs';
import { map, filter, scan, catchError, } from 'rxjs/operators';

import { HttpClient, HttpErrorResponse, HttpParams, HttpHeaders } from '@angular/common/http';


import { AuthServiceService } from './auth-service.service'
@Injectable()
export class LoginService {
  auth: any;
  constructor(private http_client: HttpClient, auth: AuthServiceService) {
    this.auth = auth;
  }

  loginUser(user: any) {
    var token = btoa(user.email + ':' + user.password);
    this.auth.setToken(token);
    let headers = new HttpHeaders();
    headers.append('Authorization', `Basic ${this.auth.getToken()}`);

    return this.http_client
      .get("http://localhost:8080/users/angularUser").pipe(
        map((data: Response) => {
          //console.log(data);
          this.auth.setUser(data);//uzeti korisnika i staviti u local storage
        }));

  }
}
