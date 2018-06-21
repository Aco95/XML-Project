import { Component, OnInit } from '@angular/core';
import { RezervacijeService } from '../../services/rezervacije.service';
import { Rezervacija } from '../../model/Rezervacija';


@Component({
  selector: 'app-home-rezervacije',
  templateUrl: './home-rezervacije.component.html',
  styleUrls: ['./home-rezervacije.component.css']
})
export class HomeRezervacijeComponent implements OnInit {

  rezervacije: Rezervacija[];

  constructor(private rezervacijeService: RezervacijeService) { }

  ngOnInit() {    
    this.getRezervacije();
  }

  getRezervacije() : void {
    this.rezervacijeService.getRezervacije()
    .subscribe(rezervacije => this.rezervacije = rezervacije);
  }

  test() {
    this.rezervacijeService.test();
  }

}
