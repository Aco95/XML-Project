import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import {Http, Response, Headers } from "@angular/http";
import { HttpHeaders, HttpClient, HttpErrorResponse, HttpParams  } from '@angular/common/http';

import { BehaviorSubject } from 'rxjs/BehaviorSubject';

import 'rxjs/Rx'

import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/toPromise';


@Injectable()
export class SearchService {

  private rez = new BehaviorSubject<any>(null);
  reservation = this.rez.asObservable();

  constructor(private http: Http) { }


  getAllAccommodations() {
    const headers = new Headers();
    headers.append('Content-Type', 'application/json');
    return this.http.get('http://localhost:8080/public/accommodations/getAll', 
      { headers : headers }).map((data : Response) => data.json());

  }

  getAccommodationAByPlace(place : any) {
    const headers = new Headers();
    headers.append('Content-Type', 'application/json');
    return this.http.get('http://localhost:8080/public/accommodations/getAccommodationByPlace/'+JSON.stringify(place), 
      { headers : headers }).map((data : Response) => data.json());

  }

  basicSearch(place:any, numberOfPersons:any, dateFrom:any, dateTo:any){
    const headers = new Headers();
    headers.append('Content-Type', 'application/json');
    return this.http.get('http://localhost:8080/public/accommodations/basicSearch/'+JSON.stringify(place)+
    "/"+JSON.stringify(numberOfPersons)+"/"+JSON.stringify(dateFrom)+"/"+JSON.stringify(dateTo), 
      { headers : headers }).map((data : Response) => data.json());

  }

  advancedSearch(place:any, numberOfPersons:any, dateFrom:any, dateTo:any,
    type:any, category:any, parking:any, wifi:any, breakfast:any, half_board:any,
    board:any, TV:any, kitchen:any, bathroom:any) {
    const headers = new Headers();
    headers.append('Content-Type', 'application/json');
    return this.http.get('http://localhost:8080/public/accommodations/advancedSearch/'+JSON.stringify(place)+"/"
    +JSON.stringify(numberOfPersons)+"/"+JSON.stringify(dateFrom)+"/"+JSON.stringify(dateTo)+"/"
    +JSON.stringify(type)+"/"+JSON.stringify(category)+"/"+JSON.stringify(parking)+"/"+JSON.stringify(wifi)+"/"
    +JSON.stringify(breakfast)+"/"+JSON.stringify(half_board)+"/"+JSON.stringify(board)+"/"
    +JSON.stringify(TV)+"/"+JSON.stringify(kitchen)+"/"+JSON.stringify(bathroom), 
      { headers : headers }).map((data : Response) => data.json());

  }


  makeReservation(reservation : any) {

    this.rez.next(reservation);
  }


}
