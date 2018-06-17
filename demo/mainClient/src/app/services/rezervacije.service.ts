import { Injectable } from '@angular/core';
import { Observable} from 'rxjs';
import { REZERVACIJE } from '../data/mock';
import { Rezervacija } from '../model/Rezervacija';
import { of } from 'rxjs/observable/of';

@Injectable()
export class RezervacijeService {

  constructor() { }

  getRezervacije(): Observable<Rezervacija[]> {
    return of(REZERVACIJE);
  }

}
