import { Component, OnInit } from '@angular/core';

import { Router } from '@angular/router';

import {NgbModule} from '@ng-bootstrap/ng-bootstrap';

import { SearchService } from "../../services/search.service";

@Component({
  selector: 'app-reserve-accommodation',
  templateUrl: './reserve-accommodation.component.html',
  styleUrls: ['./reserve-accommodation.component.css']
})
export class ReserveAccommodationComponent implements OnInit {

  private reservation: any;

  private nameOfAcccommodation : any;
  private numberOfPersons : any;
  private dateFrom : any;
  private dateTo: any;
  private price: any;

  private numberOfNights : any;

  constructor(private router : Router, private searchService : SearchService ) { }

  ngOnInit() {

    this.searchService.reservation.subscribe(
      reservation => 
      {
        this.reservation = reservation;
        console.log(reservation);

        this.nameOfAcccommodation = reservation.accommodation.naziv;
        this.numberOfPersons = reservation.numberOfPersons;
        

        this.dateFrom = reservation.dateFrom.year + "-";
        if(reservation.dateFrom.month < 10){
          this.dateFrom += "0" + reservation.dateFrom.month + "-";
        }
        else {
          this.dateFrom += reservation.dateFrom.month + "-";
        }

        if(reservation.dateFrom.day < 10){
          this.dateFrom += "0" + reservation.dateFrom.day;
        }
        else {
          this.dateFrom += reservation.dateFrom.day;
        }

        this.dateFrom += "T12:01:04.753Z";

        this.dateTo = reservation.dateTo.year + "-";
        if(reservation.dateTo.month < 10){
          this.dateTo += "0" + reservation.dateTo.month + "-";
        }
        else {
          this.dateTo += reservation.dateTo.month + "-";
        }

        if(reservation.dateTo.day < 10){
          this.dateTo += "0" + reservation.dateTo.day;
        }
        else {
          this.dateTo += reservation.dateTo.day;
        }

        this.dateTo += "T12:01:04.753Z";


        var diff = Math.abs(new Date(this.dateTo).getTime()- new Date(this.dateFrom).getTime());
        this.numberOfNights = Math.ceil(diff / (1000 * 3600 * 24)); 
        console.log(this.numberOfNights);

        this.dateFrom = reservation.dateFrom;
        this.dateTo = reservation.dateTo;

        this.price = this.numberOfNights * reservation.accommodation.cena;

      }
    );
  }

}
