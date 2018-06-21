import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import {Http, Response, Headers} from "@angular/http";

import {HttpErrorResponse} from '@angular/common/http';

import 'rxjs/Rx'


import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/toPromise';
@Injectable()
export class SobaService {

  constructor(private http: Http) { }


  changeSchedule(room : any) {
    const headers = new Headers();
    headers.append('Content-Type', 'application/json');
    return this.http.put('http://localhost:8081/sobe/changeSobaSchedule', 
      JSON.stringify(room), { headers : headers }).map((data : Response) => data.json());
  }

}
