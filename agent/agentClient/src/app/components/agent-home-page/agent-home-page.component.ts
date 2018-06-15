import { Component, OnInit } from '@angular/core';

import {SmestajService} from '../../services/smestaj.service'

@Component({
  selector: 'app-agent-home-page',
  templateUrl: './agent-home-page.component.html',
  styleUrls: ['./agent-home-page.component.css']
})
export class AgentHomePageComponent implements OnInit {

  activities : string[];
  panels : boolean[];
  accommodations : any[];
  accommodationName : string;
  accommodationAddress : string;
  accommodationCity : string;
  accommodationDescription : string;
  accommodationImage : string;
  accommodationType : string;
  accommodationSingleRooms : number;
  accommodationDoubleRooms : number;
  accommodationTripleRooms : number;
  accommodationQuadRooms : number;
  accommodationWIFI : boolean;
  accommodationPARKING : boolean;
  accommodationTV : boolean;
  accommodationBREAKFAST : boolean;
  accommodationBOARDING_HOUSE : boolean;
  accommodationHALF_BOARD : boolean;
  accommodationSMALL_KITCHEN : boolean;
  accommodationPRIVATE_BATHROOM : boolean;

  constructor(private smestajService : SmestajService) { }

  ngOnInit() { 

    this.activities = ["app-menu__item active", "app-menu__item", "app-menu__item", "app-menu__item", "app-menu__item"];
    this.panels = [true, false, false, false, false];
    this.getAccomodations();
    this.accommodationType = "HOTEL";
    
  }


  switchActiveTab(index : number) {


    for (var i = 0; i < this.activities.length; i++) {
      this.activities[i] = "app-menu__item";
      
    }

    for (var j = 0; j < this.panels.length; j++) {
      this.panels[j] = false;
      
    }

    this.activities[index] = "app-menu__item active";
    this.panels[index] = true;

  }

  getAccomodations() {


    this.smestajService.getSmestaji().subscribe(data=> { this.accommodations = data; console.log(data)});

  }

  insertNewAccommodation() {


    
  }

 

}
