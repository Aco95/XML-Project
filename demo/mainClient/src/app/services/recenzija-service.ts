import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Router} from '@angular/router';

import { Recenzija } from '../model/Recenzija'
import { HttpHeaders } from '@angular/common/http';

@Injectable()
export class RecenzijaService{

    constructor(private http: HttpClient, private router: Router) { }

    public createRecenzija(recenzija: Recenzija){
      return this.http.post<Recenzija>('http://localhost:8080/recenzijaOffline/postRecenzija', recenzija);
      
    }
}