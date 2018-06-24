import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FormBuilder, FormGroup, FormControl, Validators } from '@angular/forms';
import { Recenzija } from '../../model/Recenzija';
import { RecenzijaService } from '../../services/recenzija-service';
import { Korisnik } from '../../model/Korisnik';
import { AuthServiceService} from '../../services/auth-service.service';


@Component({
  selector: 'app-recenzija',
  templateUrl: './recenzija.component.html',
  styleUrls: ['./recenzija.component.css']
})
export class RecenzijaComponent implements OnInit {
  recenzija: Recenzija = new Recenzija();
  form: FormGroup;
  idSmestaja: string;
  korisnik: Korisnik;
  constructor(private authService:AuthServiceService, private router: Router, private formBuilder: FormBuilder, private recenzijaService: RecenzijaService) { }
  

  ngOnInit() {

    this.idSmestaja = localStorage.getItem('recenzijaSmestaj');

    this.form = this.formBuilder.group({
      id: new FormControl(this.recenzija.id),
      ocena: new FormControl(this.recenzija.ocena,[Validators.required]),
      korisnik: new FormControl(this.recenzija.korisnik),
      komentar: new FormControl(this.recenzija.komentar.sadrzaj),
      smestaj: new FormControl(this.recenzija.smestajId),      
    });
  }


  redirect(){
    this.router.navigate(['/rezervacije']);
  }

  submit(event: any){

    this.korisnik = this.authService.getUser();

    this.recenzija.ocena = ((document.getElementById("ocena") as HTMLSelectElement).selectedIndex + 1);
    this.recenzija.komentar.sadrzaj = ((document.getElementById("komentar") as HTMLInputElement).value);
    this.recenzija.smestajId = this.idSmestaja;
    this.recenzija.korisnik = this.korisnik;
    console.log(this.recenzija);
    //this.recenzijaService.createRecenzija(this.recenzija).subscribe( data => this.router.navigate(['/rezervacije']));
    this.recenzijaService.createRecenzija(this.recenzija).subscribe(data =>{
      this.router.navigate['/rezervacije'];
    });
  }
}
