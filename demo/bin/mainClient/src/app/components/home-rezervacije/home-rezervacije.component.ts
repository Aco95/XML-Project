import { Component, OnInit } from '@angular/core';
import { KORISNICI, REZERVACIJE, SMESTAJI, SOBE } from '../../data/mock';


@Component({
  selector: 'app-home-rezervacije',
  templateUrl: './home-rezervacije.component.html',
  styleUrls: ['./home-rezervacije.component.css']
})
export class HomeRezervacijeComponent implements OnInit {

  korisnici = KORISNICI;
  rezervacije = REZERVACIJE;
  smestaji = SMESTAJI;
  sobe = SOBE;

  constructor() { }

  ngOnInit() {
    console.log(this.sobe[1].idSmestaja);
    
  }

}
