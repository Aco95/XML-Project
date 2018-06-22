import { Component, OnInit } from '@angular/core';
import { RezervacijeService } from '../../services/rezervacije.service';
import { Rezervacija } from '../../model/Rezervacija';
import { Router } from '@angular/router';

import { Smestaj } from '../../model/Smestaj';
import { Soba } from '../../model/Soba';
import { AuthServiceService } from '../../services/auth-service.service';


@Component({
  selector: 'app-home-rezervacije',
  templateUrl: './home-rezervacije.component.html',
  styleUrls: ['./home-rezervacije.component.css']
})
export class HomeRezervacijeComponent implements OnInit {

  rezervacije: Rezervacija[];
  retVal: any;
  tempRez: Rezervacija;
  smestaji: Smestaj[];
  sobe: Soba[];
  user: any | null;

  constructor(private rezervacijeService: RezervacijeService, private authService: AuthServiceService, private router: Router) { }

  ngOnInit() {    
    this.getRezervacije();
    this.retVal = [];
    this.user = this.authService.getUser();
  }

  getRezervacije() {
    this.rezervacijeService.getRezervacije()
    .subscribe(rezervacije => this.rezervacije = rezervacije);
  }

  getUserReservation() {
    this.rezervacijeService.getUserReservation(this.user.id).subscribe(
      (data: Rezervacija[]) => {
        this.retVal = data;   
        this.smestaji = new Array(data.length);
        this.sobe = new Array(data.length);     
        console.log("Smestaj length: "+this.smestaji.length);
        var i:number;
        for(i = 0; i < data.length; i++) {
          this.getSmestajByRoomID(data[i].idSobe, i);
          this.getSobaInfo(data[i].idSobe,i);
        }
      }
    )
  }

  getSmestajByRoomID(roomID: String, i: number) {
    this.rezervacijeService.getSmestajByRoomID(roomID).subscribe(
      (smestaj:Smestaj) => {
        console.log(smestaj.naziv);
        this.smestaji[i] = smestaj;
      }
    )
    
  }

  getSobaInfo(roomID: String, i:number) {
    this.rezervacijeService.getRoomByID(roomID).subscribe(
      (soba: Soba) => {
        console.log(soba);
        this.sobe[i] = soba
      }
    )
    
  }

  createRcensia(){
    this.router.navigate(['/create-recenzija']);
  }


  cancelReservation(rezervacija : any) {
   
    this.rezervacijeService.deleteReservation(rezervacija.id)
    .subscribe(data => {
      
      this.retVal = data;
      alert(this.retVal);
      alert("You have successfully canceled your reservation.");  

      } 
    );


  }

}
