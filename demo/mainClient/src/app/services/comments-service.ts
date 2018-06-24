import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';

import {Smestaj} from '../model/Smestaj'
import { Recenzija } from '../model/Recenzija';

@Injectable()
export class CommentsService{

    constructor(private http:HttpClient){}

    public getSelectedSmestaj() {
        let id = localStorage.getItem('activeComments');
        return this.http.get<Smestaj>('http://localhost:8080/public/accommodations/getSmestaj/' + id);
    }

    public getRecenzije(){
        return this.http.get<Recenzija[]>('http://localhost:8080/recenzijaOffline');
    }
}

