import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';

import { Recenzija } from '../model/Recenzija'
import { HttpHeaders } from '@angular/common/http';

@Injectable()
export class RecenzijaService{

    constructor(private http: HttpClient) { }

    public createRecenzija(recenzija: Recenzija){
        
        console.log("Treba da pozove backend");
        return "AAAAAA";
    }
}