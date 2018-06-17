import { Component, OnInit } from '@angular/core';
import { ManageKorisnikService } from "../../services/manage-korisnik.service";
import { AdminKorisnik } from '../../models/admin-korisnik';

@Component({
  selector: 'app-manage-korisnik',
  templateUrl: './manage-korisnik.component.html',
  styleUrls: ['./manage-korisnik.component.css']
})
export class ManageKorisnikComponent implements OnInit {
  korisnici: any = [];
  constructor(private manageKorisnikService: ManageKorisnikService) { }

  ngOnInit() {

    this.getAllKorisnik();
  }

  getAllKorisnik() {
    this.manageKorisnikService.getAll().subscribe(data => {
      this.korisnici = data
    });
  }
  remove(id: string) {
    this.manageKorisnikService.remove(id).subscribe(() => this.getAllKorisnik())
  }
  changeStatus(id: string, status: boolean) {
    this.manageKorisnikService.changeStatus(id, status).subscribe(() => this.getAllKorisnik())
  }

}
