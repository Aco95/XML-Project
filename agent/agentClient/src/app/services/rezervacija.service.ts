import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import {Http, Response, Headers} from "@angular/http";

import {HttpErrorResponse} from '@angular/common/http';

import 'rxjs/Rx'


import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/toPromise';

@Injectable()
export class RezervacijaService {

  constructor(private http: Http) { }


  getRezervacije(){


    const headers = new Headers();
    headers.append('Content-Type', 'application/json');

    return this.http.get("http://localhost:8081/rezervacije/getAll").map(data => data.json())

    .catch((err:HttpErrorResponse) =>
    {
        alert(err.status + " " + err.error.error + " \n" + err.error.message);
        return Observable.throw(err);
    });
  
  }

  getNoveRezervacije(){


    const headers = new Headers();
    headers.append('Content-Type', 'application/json');

    return this.http.get("http://localhost:8081/rezervacije/getNewReservations").map(data => data.json())

    .catch((err:HttpErrorResponse) =>
    {
        alert(err.status + " " + err.error.error + " \n" + err.error.message);
        return Observable.throw(err);
    });
  
  }

  changeRealization(reservation : any) {
    const headers = new Headers();
    headers.append('Content-Type', 'application/json');
    return this.http.put('http://localhost:8081/rezervacije/changeRealizacija', 
      JSON.stringify(reservation), { headers : headers }).map((data : Response) => data.json());
  }

}
