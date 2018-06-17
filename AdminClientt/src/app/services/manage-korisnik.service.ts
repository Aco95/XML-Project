import { Injectable } from '@angular/core';
import { Observable, Subject, asapScheduler, pipe, of, from, interval, merge, fromEvent } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { map, filter, scan, catchError, } from 'rxjs/operators';

@Injectable({
    providedIn: 'root'
})
export class ManageKorisnikService {

    constructor(private http_client: HttpClient) { }
    // getAll(korisnik_id: string) {
    //     return this.http_client.get("http://localhost:8080/admin/korisnik").pipe(
    //         map(data => data.json())
    //     )
    // }
    getAll() {
        return this.http_client.get("http://localhost:8080/admin/korisnik");
    }

    changeStatus(id: string, status: boolean) {
        return this.http_client.get(`http://localhost:8080/admin/korisnik/${id}/${status}`);
    }

    remove(id: string) {
        return this.http_client.delete(`http://localhost:8080/admin/korisnik/${id}`);
    }
}
