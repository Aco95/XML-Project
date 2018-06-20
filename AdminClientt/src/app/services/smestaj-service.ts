import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';

import { Smestaj } from '../entities/smestaj';
import { HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class SmestajService {
  
  private serviceUrl = '/api_comment';
  
  constructor(private http: HttpClient) { }
  
  public deleteSmestaj(smestaj: Smestaj){
    return this.http.delete<Smestaj>(this.serviceUrl + '/deleteSmestaj/' + smestaj.id);
  }
  
  public editSmestaj(smestaj: Smestaj) {    
    return this.http.put<Smestaj>(this.serviceUrl + '/editSmestaj', smestaj);
  }
  
  public getAllSmestaj() {
    return this.http.get<Smestaj[]>(this.serviceUrl + '/getAll');
  }
  
  public getEditedSmestaj() {
    let id = localStorage.getItem('activeEdit');
    return this.http.get<Smestaj>(this.serviceUrl + '/getActiveEdit/' + id);
  }
  
}
