import { Component, OnInit, Inject } from '@angular/core';
import { Router } from '@angular/router';
import { FormBuilder, FormGroup, FormControl, Validators } from '@angular/forms';

import { Smestaj } from '../../entities/smestaj';
import { SmestajService } from '../../services/smestaj-service';

@Component({
  selector: 'app-edit-smestaj',
  templateUrl: './edit-smestaj.component.html',
  styleUrls: ['./edit-smestaj.component.css']
})
export class EditSmestajComponent implements OnInit {
  smestaj: Smestaj;
  form: FormGroup;
  
  constructor(private formBuilder: FormBuilder, private router: Router, private smestajService: SmestajService) 
  { 
    
  }

  ngOnInit() {
    this.smestajService.getEditedSmestaj().subscribe( data => {
      this.smestaj = data;   
      
      this.form = this.formBuilder.group({
      id: new FormControl(this.smestaj.id),
      naziv: new FormControl(this.smestaj.naziv, [Validators.required]),
      adresa: new FormControl(this.smestaj.adresa, [Validators.required]),
      mesto: new FormControl(this.smestaj.mesto , [Validators.required]),
      tip: new FormControl('', [Validators.required]),
      parking: new FormControl(this.smestaj.parking),
      wifi: new FormControl(this.smestaj.wifi),
      dorucak: new FormControl(this.smestaj.dorucak),
      polupansion: new FormControl(this.smestaj.polupansion),
      pansion: new FormControl(this.smestaj.pansion, [Validators.required]),
      tv: new FormControl(this.smestaj.tv, [Validators.required]),
      miniKuhinja: new FormControl(this.smestaj.miniKuhinja),
      privatnoKupatilo: new FormControl(this.smestaj.privatnoKupatilo),
      opis: new FormControl(this.smestaj.opis, [Validators.required]),
      
    });

      console.log(this.smestaj)
    })
  }
  
  redirect() {
    this.router.navigate(['./homePage']);
  }
  
  submit(event: any) {
    this.smestaj = this.form.value;
    console.log(this.smestaj);
    this.smestajService.editSmestaj(this.smestaj).subscribe
      (data => this.router.navigate(['/homePage']));
  }

}
