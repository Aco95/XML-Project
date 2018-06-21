import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import {Http, Response, Headers} from "@angular/http";

import {HttpErrorResponse} from '@angular/common/http';

import 'rxjs/Rx'


import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/toPromise';

@Injectable()
export class SmestajService {

  constructor(private http: Http) { }


  getSmestaji(){


    const headers = new Headers();
    headers.append('Content-Type', 'application/json');

    return this.http.get("http://localhost:8081/smestaji/getAll").map(data => data.json())

    .catch((err:HttpErrorResponse) =>
    {
        alert(err.status + " " + err.error.error + " \n" + err.error.message);
        return Observable.throw(err);
    });
  
  }

  insertAccommodation(accommodation : any) {

    const headers = new Headers();
    headers.append('Content-Type', 'application/json');
    return this.http.post('http://localhost:8081/smestaji/insert', 
      JSON.stringify(accommodation), { headers : headers }).map((data : Response) => data.json());
  }

}
