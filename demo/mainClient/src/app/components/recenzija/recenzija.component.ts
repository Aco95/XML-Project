import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FormBuilder, FormGroup, FormControl, Validators } from '@angular/forms';
import { Recenzija } from '../../model/Recenzija';
import { RecenzijaService } from '../../services/recenzija-service';


@Component({
  selector: 'app-recenzija',
  templateUrl: './recenzija.component.html',
  styleUrls: ['./recenzija.component.css']
})
export class RecenzijaComponent implements OnInit {
  recenzija: Recenzija = new Recenzija();
  form: FormGroup;

  constructor(private router: Router, private formBuilder: FormBuilder, private recenzijaService: RecenzijaService) { }
  

  ngOnInit() {
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
    this.recenzija.ocena = ((document.getElementById("ocena") as HTMLSelectElement).selectedIndex + 1);
    this.recenzija.komentar.sadrzaj = ((document.getElementById("komentar") as HTMLInputElement).value);
    console.log(this.recenzija);
    //this.recenzijaService.createRecenzija(this.recenzija).subscribe( data => this.router.navigate(['/rezervacije']));
    this.recenzijaService.createRecenzija(this.recenzija);
  }
}
