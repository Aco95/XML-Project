import { Component, OnInit } from '@angular/core';

import {CommentsService} from '../../services/comments-service';
import { UserService } from '../../services/user.service';
import { AuthServiceService} from '../../services/auth-service.service';
import {Smestaj} from '../../model/Smestaj';
import { Recenzija } from '../../model/Recenzija';
import { Korisnik } from '../../model/Korisnik';
import { Uloga } from '../../model/Uloga.enum';


@Component({
  selector: 'app-comments',
  templateUrl: './comments.component.html',
  styleUrls: ['./comments.component.css']
})
export class CommentsComponent implements OnInit {
  smestaj: Smestaj;
  recenzije: Recenzija[];
  recenzijeFront: Recenzija[] = new Array();
  korisnik: Korisnik;
  constructor(private commentsService: CommentsService, private userService: UserService, private authService: AuthServiceService) { }

  ngOnInit() {

    this.commentsService.getSelectedSmestaj().subscribe(data => {
      this.smestaj = data;
      console.log(this.smestaj);
    });

    this.korisnik = this.authService.getUser();
    console.log("KORISNIK");
    console.log(this.korisnik.uloga);

    this.commentsService.getRecenzije().subscribe(data => {
      console.log("TRAZI RECENZIJE");
      this.recenzije = data;
      for(let entry of this.recenzije) {        
        if( entry.smestajId == this.smestaj.id && (entry.komentar.odobren==true || (this.korisnik.uloga.toString() == 'ADMIN' || this.korisnik.uloga.toString() == 'AGENT'))){         
            this.recenzijeFront.push(entry);
        }
      }
      console.log("RECENZIJEEE");
      console.log(this.recenzije);
    })

  }

}
