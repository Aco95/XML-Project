import { Injectable } from '@angular/core';
import { Observable} from 'rxjs';
import { REZERVACIJE } from '../data/mock';
import { Rezervacija } from '../model/Rezervacija';
import { of } from 'rxjs/observable/of';


import {Http, Response, Headers } from "@angular/http";
import { HttpHeaders, HttpClient, HttpErrorResponse, HttpParams  } from '@angular/common/http';

import { BehaviorSubject } from 'rxjs/BehaviorSubject';

import 'rxjs/Rx'

import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/toPromise';

@Injectable()
export class RezervacijeService {

  s = "";

  private a = new BehaviorSubject<any>(null);
  currentAgent = this.a.asObservable();

  constructor(private http: Http, private httpClient: HttpClient) { }

  getRezervacije(): Observable<Rezervacija[]> {
    return of(REZERVACIJE);
  }


  addReservation(reservationDTO : any) {

    const headers = new Headers();
    headers.append('Content-Type', 'application/json');
    // alert(JSON.stringify(reservationDTO));
    return this.http.post('http://localhost:8080/public/reservations/addReservation', 
      JSON.stringify(reservationDTO), { headers : headers }).map((data : Response) => data.json());
  }

  getUserReservation(userID:String) {
    return this.http.post('http://localhost:8080/public/reservations/get-user-reservation', userID ).map(
      (data:Response) => data.json()
    );
  }

  getUserReservationActive(userId:string){
    return this.httpClient.get<Rezervacija[]>('http://localhost:8080/public/reservations/get-user-reservation-active/'+userId);
  }

  getUserReservationPassed(userId:string){
    return this.httpClient.get<Rezervacija[]>('http://localhost:8080/public/reservations/get-user-reservation-passed/'+userId);
  }

  getSmestajByRoomID(roomID:String) {
    return this.http.get('http://localhost:8080/public/rooms/getSmestaj/'+roomID).map(
      (data:Response) => data.json()
    );
  }

  getRoomByID(roomID) {
    return this.http.get('http://localhost:8080/public/rooms/getRoom/'+roomID).map(
      (data: Response) => data.json()
    );
  }


  deleteReservation(reservationID : any) {

    const headers = new Headers();
    headers.append('Content-Type', 'application/json');

    return this.http.delete('http://localhost:8080/public/reservations/deleteReservation/'+JSON.stringify(reservationID), 
       { headers : headers }).map((data : Response) => data.json());
  }

  getUserById(userID : any) {
    console.log(userID);
    const headers = new Headers();
    headers.append('Content-Type', 'application/json');
    return this.http.get('http://localhost:8080/public/reservations/getUserById/'+JSON.stringify(userID), 
      { headers : headers }).map((data : Response) => data.json());

  }

  getUserByUsername(username : any) {     // treba mi kontroler za ovo
    console.log(username);
    const headers = new Headers();
    headers.append('Content-Type', 'application/json');
    return this.http.get('http://localhost:8080/public/reservations/getUserByUsername/'+JSON.stringify(username), 
      { headers : headers }).map((data : Response) => data.json());

  }

  selectAgent(agent : any) {

    this.a.next(agent);
  }


  sendMessage(porukaDTO : any) {

    const headers = new Headers();
    headers.append('Content-Type', 'application/json');
    // alert(JSON.stringify(reservationDTO));
    return this.http.post('http://localhost:8080/public/messages/sendMessage', 
      JSON.stringify(porukaDTO), { headers : headers }).map((data : Response) => data.json());
  }


  getInbox(){

    const headers = new Headers();
    headers.append('Content-Type', 'application/json');

    return this.http.get("http://localhost:8080/public/messages/getPrimljenePoruke").map(data => data.json())

    .catch((err:HttpErrorResponse) =>
    {
        alert(err.status + " " + err.error.error + " \n" + err.error.message);
        return Observable.throw(err);
    });
  
  }

  getSent(){

    const headers = new Headers();
    headers.append('Content-Type', 'application/json');

    return this.http.get("http://localhost:8080/public/messages/getPoslatePoruke").map(data => data.json())

    .catch((err:HttpErrorResponse) =>
    {
        alert(err.status + " " + err.error.error + " \n" + err.error.message);
        return Observable.throw(err);
    });
  
  }

  getAgenti(){                          // treba mi kontroler za ovo
    const headers = new Headers();
    headers.append('Content-Type', 'application/json');
    return this.http.get('http://localhost:8080/public/reservations/getAgenti', 
      { headers : headers }).map((data : Response) => data.json());
  }

}
