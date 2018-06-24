import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';

import {Comment} from '../entities/comment';
import { HttpHeaders } from '@angular/common/http';
import { Recenzija } from '../entities/recenzija';

/*const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
};*/


@Injectable()
export class CommentService {
  
  private commentUrl = 'http://localhost:8080/recenzijaOffline';
  
  constructor(private http: HttpClient) {}
  
  public getAllComments() {
    return this.http.get<Recenzija[]>(this.commentUrl+'/getNotAllowed');
  }
  
  public allowComment(recenzija) {
    console.log('Salje komentar na server');
    return this.http.put<Recenzija>(this.commentUrl, recenzija);
  }
}