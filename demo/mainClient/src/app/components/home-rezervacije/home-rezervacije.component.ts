import { Component, OnInit } from '@angular/core';
import { RezervacijeService } from '../../services/rezervacije.service';
import { Rezervacija } from '../../model/Rezervacija';
import { Router } from '@angular/router';

import { Smestaj } from '../../model/Smestaj';


@Component({
  selector: 'app-home-rezervacije',
  templateUrl: './home-rezervacije.component.html',
  styleUrls: ['./home-rezervacije.component.css']
})
export class HomeRezervacijeComponent implements OnInit {

  rezervacije: Rezervacija[];
  retVal: any;
  tempRez : Rezervacija;
  smestajID : String;

  constructor(private rezervacijeService: RezervacijeService, private router: Router) { }

  ngOnInit() {    
    this.getRezervacije();
    this.retVal = [];
  }

  getRezervacije() : void {
    this.rezervacijeService.getRezervacije()
    .subscribe(rezervacije => this.rezervacije = rezervacije);
  }

  getUserReservation() {
    this.rezervacijeService.getUserReservation('3').subscribe(
      (data: Rezervacija[]) => {
        this.retVal = data;
        console.log(data);         
        //prodji skroz sve rezervacije       
        this.getSmestajByRoomID('5')
      }
    )
  }

  getSmestajByRoomID(roomID: String) {

    this.rezervacijeService.getSmestajByRoomID(roomID).subscribe(
      (smestaj:String) => {
        console.log(smestaj);
        this.smestajID = smestaj;        
      }
    )
  }

  createRcensia(){
    this.router.navigate(['/create-recenzija']);
  }

}
