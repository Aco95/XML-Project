import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';

import {Comment} from '../entities/comment';
import { HttpHeaders } from '@angular/common/http';

/*const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
};*/


@Injectable()
export class CommentService {
  
  private commentUrl = '/api_comment';
  
  constructor(private http: HttpClient) {}
  
  public getAllComments() {
    return this.http.get<Comment[]>(this.commentUrl);
  }
  
  public allowComment(comment) {
    console.log('Salje komentar na server');
    return this.http.put<Comment>(this.commentUrl, comment);
  }
}