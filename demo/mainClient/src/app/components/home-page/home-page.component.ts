import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import {NgbModule} from '@ng-bootstrap/ng-bootstrap';

import { SearchService } from "../../services/search.service";

@Component({
  selector: 'app-home-page',
  templateUrl: './home-page.component.html',
  styleUrls: ['./home-page.component.css']
})
export class HomePageComponent implements OnInit {

  private accommodationArray : any;

  private place : any;
  private numberOfPersons : any;
  private dateFrom : any;
  private dateTo: any;

  private minDateFrom : any;
  private minDateTo : any;

  private type : any;
  private category : any;
  private parking : any;
  private wifi : any;
  private breakfast : any;
  private half_board : any;
  private board : any;
  private TV : any;
  private kitchen : any;
  private bathroom : any;

  private isOpenAdvancedSearch : boolean;
  public isOpenRezervacije : boolean;


  constructor(private router : Router, private searchService : SearchService ) { }

  ngOnInit() {

    this.accommodationArray = [];
    this.numberOfPersons = "1";
    this.type = "0";
    this.category = "1";
    this.minDateFrom = {year: 2018, month: 6, day: 15};
    
    this.parking = false;
    this.wifi = false;
    this.breakfast = false;
    this.half_board = false;
    this.board = false;
    this.TV = false;
    this.kitchen = false;
    this.bathroom = false;

    this.isOpenAdvancedSearch = false;
    this.isOpenRezervacije = false;

  }

  chooseDateFrom() {
    this.minDateTo = this.dateFrom;
  }


  clickRezervacije() {
    if(!this.isOpenRezervacije) {
      this.isOpenRezervacije = true;
    }
    else {
      this.isOpenRezervacije = false;
    }
    console.log(this.isOpenRezervacije);
    
  }


  clickAdvancedSearch() {

    if(!this.isOpenAdvancedSearch){
      this.isOpenAdvancedSearch = true;
      // alert("Opened");

    } else {
      this.isOpenAdvancedSearch = false;
      // alert("Closed");

    }

  }

  submitSearch() {
    if(!this.isOpenAdvancedSearch){
      
      this.searchService.basicSearch(this.place, this.numberOfPersons, this.dateFrom, this.dateTo)
      .subscribe(data => {

          if(data.greska)
            alert("Please fill in all fields");

          else {
            this.accommodationArray = data.trazeniSmestaji;
            console.log(this.accommodationArray);
          }
            
        } 
      );

    } else {

      this.searchService.advancedSearch(this.place, this.numberOfPersons, this.dateFrom, this.dateTo,
      this.type, this.category, this.parking, this.wifi, this.breakfast, this.half_board,
      this.board, this.TV, this.kitchen, this.bathroom)
      .subscribe(data => { 

          if(data.greska)
            alert("Please fill in all fields");

          else {
            this.accommodationArray = data.trazeniSmestaji;
            console.log(this.accommodationArray);
          }

        } 
      );

    }
  }

}
