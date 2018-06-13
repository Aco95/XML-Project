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


  constructor(private router : Router, private searchService : SearchService ) { }

  ngOnInit() {

    this.isOpenAdvancedSearch = false;

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
          console.log(data);
          this.accommodationArray = data;
        } 
      );

    } else {

      this.searchService.advancedSearch(this.place, this.numberOfPersons, this.dateFrom, this.dateTo,
      this.type, this.category, this.parking, this.wifi, this.breakfast, this.half_board,
      this.board, this.TV, this.kitchen, this.bathroom)
      .subscribe(data => {
          console.log(data);
          this.accommodationArray = data;
        } 
      );

    }
  }

}
