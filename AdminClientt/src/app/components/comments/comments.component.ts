import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { Comment } from '../../entities/comment';
import { CommentService } from '../../services/comment-service';


@Component({
  selector: 'app-comments',
  templateUrl: './comments.component.html',
  styleUrls: ['./comments.component.css']
})
  
export class CommentsComponent implements OnInit {
  comments: Comment[];
  
  constructor(private router: Router, private commentService: CommentService) {}
 
  ngOnInit() {
    this.commentService.getAllComments().subscribe( data => {
      this.comments = data;
      console.log(this.comments);
    });
  }
  
  allowComment(komentar: Comment) {
    this.commentService.allowComment(komentar).subscribe(data => this.comments = this.comments.filter(u => u !== komentar));
  }
}
