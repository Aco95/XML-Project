import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import {NgbModule} from '@ng-bootstrap/ng-bootstrap';

import { SearchService } from "../../services/search.service";
import { Smestaj } from "../../model/Smestaj"

import { AuthServiceService} from '../../services/auth-service.service';

import { FormControl, Validators} from "@angular/forms";
// import { FormControl } from '@angular/forms';

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
  private priceFrom: any;
  private priceTo: any;

  private rating: any;


  private minDateFrom : any;
  private minDateTo : any;
  private minPriceTo: any;

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
  private isOpenRezervacije : boolean;

  private loggedInUser : any;
  // private isLoggedIn = true;    
  
  private listMinPrice = [];
  private listMaxPrice = [];

  private sortType = '';


  constructor(private router : Router, private searchService : SearchService, private authService : AuthServiceService) { }

  ngOnInit() {

    this.accommodationArray = [];
    this.numberOfPersons = "1";
    this.type = "0";
    this.category = "1";
    const today = new Date();
    const dd = today.getDate();
    const mm = today.getMonth() + 1; // January is 0!
    const yyyy = today.getFullYear();
    this.minDateFrom = {year: yyyy, month: mm, day: dd};

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

    this.loggedInUser = this.authService.getUser();

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
      
      this.searchService.basicSearch(this.place, this.numberOfPersons, this.dateFrom, this.dateTo, this.priceFrom, this.priceTo)
      .subscribe(data => {

          if(data.greska){
            alert("Please fill in all fields");
            this.router.navigateByUrl('/homeSearch');
          }
          else {
            this.accommodationArray = data.trazeniSmestaji;
            console.log(this.accommodationArray);

            for(let accommodation of this.accommodationArray){
              let min = 200;
              let max = 200;
              for(let room of accommodation.sobe){
                if(room.cena<min)
                  min = room.cena;

                if(room.cena > max)
                  max = room.cena;
              }

              this.listMaxPrice.push(max);
              this.listMinPrice.push(min);

            }
            
          }
            
        } 
      );

    } else {

      this.searchService.advancedSearch(this.place, this.numberOfPersons, this.dateFrom, this.dateTo, this.priceFrom, this.priceTo,
      this.type, this.category, this.parking, this.wifi, this.breakfast, this.half_board,
      this.board, this.TV, this.kitchen, this.bathroom)
      .subscribe(data => { 

          if(data.greska){
            alert("Please fill in all fields");
            this.router.navigateByUrl('/homeSearch');
          }
          else {
            this.accommodationArray = data.trazeniSmestaji;
            console.log(this.accommodationArray);

            for(let accommodation of this.accommodationArray){
              let min = accommodation.soba[0].cena;
              let max = accommodation.soba[0].cena;
              for(let room of accommodation.soba){
                if(room.cena<min)
                  min = room.cena;

                if(room.cena > max)
                  max = room.cena;
              }

              this.listMaxPrice.push(max);
              this.listMinPrice.push(min);

            }
              
          }

        } 
      );

    }
  }


  onClickReserveAccommodation(Accommodation:any) : void {

    this.searchService.makeReservation({accommodation:Accommodation, numberOfPersons:this.numberOfPersons, dateFrom:this.dateFrom, dateTo:this.dateTo});

    if(this.loggedInUser != null) {
      this.searchService.reservation.subscribe(
        reservation => 
        {
        console.log("Reservation: " +  reservation);
        }
      );

      this.router.navigateByUrl('/reserveAccommodation');
    }

    else {
      this.router.navigateByUrl('/login');
    }

  }

  viewComments(smestaj: Smestaj) {
    console.log("Selektovani smestaj je:");
    console.log(smestaj.id);
    localStorage.setItem('activeComments', smestaj.id);
    this.router.navigate(['/accommodationComments'])
  }
  selectSort() {

    console.log(this.accommodationArray);

    if(this.sortType == "Price")
    {
        this.accommodationArray.sort( ( a, b) => {
          console.log(a.sobe[0].cena);
            return (a.sobe[0].cena - b.sobe[0].cena);
        });
    }
    else if(this.sortType == "Category")
    {  
        this.accommodationArray.sort( ( a, b) => {
            console.log(a.kategorija);
            return (a.kategorija - b.kategorija);
        });
    }
    else if(this.sortType == "Rating")
    {
        this.accommodationArray.sort( ( a, b) => {
            console.log(a.ocena);
            return (a.ocena - b.ocena);
        });
    }

    console.log(this.accommodationArray);

  }
 


}


