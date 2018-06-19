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

  private currentAccommodation: any;

  constructor(private router : Router, private searchService : SearchService ) { }

  ngOnInit() {

    this.searchService.currentAccommodation.subscribe(
      currentAccommodation => 
      {
        this.currentAccommodation = currentAccommodation;
        console.log(currentAccommodation);

      }
    );
  }

}
