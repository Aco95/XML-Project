import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { Smestaj } from '../../entities/smestaj';
import { SmestajService } from '../../services/smestaj-service';

@Component({
  selector: 'app-edit-smestaj',
  templateUrl: './edit-smestaj.component.html',
  styleUrls: ['./edit-smestaj.component.css']
})
export class EditSmestajComponent implements OnInit {
  smestaj: Smestaj;
  
  constructor(private router: Router, private smestajService: SmestajService) { }

  ngOnInit() {
    this.smestajService.getEditedSmestaj().subscribe( data => {
      this.smestaj = data;
      console.log(this.smestaj)
    })
  }

}
