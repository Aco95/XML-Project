import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { Comment } from '../../entities/comment';
import { Recenzija } from '../../entities/recenzija';
import { CommentService } from '../../services/comment-service';


@Component({
  selector: 'app-comments',
  templateUrl: './comments.component.html',
  styleUrls: ['./comments.component.css']
})
  
export class CommentsComponent implements OnInit {
  recenzije: Recenzija[];
  
  constructor(private router: Router, private commentService: CommentService) {}
 
  ngOnInit() {
    this.commentService.getAllComments().subscribe( data => {
      this.recenzije = data;
      console.log(this.recenzije);
    });
  }
  
  allowComment(recenzija: Recenzija) {
    this.commentService.allowComment(recenzija).subscribe(data => this.recenzije = this.recenzije.filter(u => u !== recenzija));
  }
}
