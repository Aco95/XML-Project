import { Component, OnInit } from '@angular/core';
import { ManageKorisnikService } from "../../services/manage-korisnik.service";

@Component({
  selector: 'app-manage-korisnik',
  templateUrl: './manage-korisnik.component.html',
  styleUrls: ['./manage-korisnik.component.css']
})
export class ManageKorisnikComponent implements OnInit {
  korisnici: any = [];
  constructor(private manageKorisnikService: ManageKorisnikService) { }

  ngOnInit() {
    //this.getAll();
  }

  /*getAll() {
    this.manageKorisnikService.getAll('1').subscribe(data => {
      this.korisnici = data);
  });

  }*/
}
