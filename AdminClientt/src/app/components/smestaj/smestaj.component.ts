import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { Smestaj } from '../../entities/smestaj';
import { SmestajService } from '../../services/smestaj-service';

@Component({
  selector: 'app-smestaj',
  templateUrl: './smestaj.component.html',
  styleUrls: ['./smestaj.component.css']
})
export class SmestajComponent implements OnInit {
  
  smestaji: Smestaj[];
  
  
  constructor(private router: Router, private smestajService: SmestajService) { }

  ngOnInit() {
    this.smestajService.getAllSmestaj().subscribe( data => {
      this.smestaji = data;
      console.log(this.smestaji);
    })
  }
  
  editSmestaj(smestaj: Smestaj) {
    localStorage.setItem('activeEdit', smestaj.id);
    this.router.navigate(['/edit-smestaj']);
  }
  
  deleteSmestaj(smestaj: Smestaj) {
    this.smestajService.deleteSmestaj(smestaj).subscribe(data => this.smestaji = this.smestaji.filter(u => u !== smestaj));
  }
  
}
