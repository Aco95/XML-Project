import { Injectable } from '@angular/core';
import { Observable, Subject, asapScheduler, pipe, of, from, interval, merge, fromEvent } from 'rxjs';
import { map, filter, scan, catchError, } from 'rxjs/operators';
import { HttpClient } from '@angular/common/http';
import { RegisterAgent } from '../models/register-agent';


@Injectable({
  providedIn: 'root'
})
export class RegisterAgentService {

  constructor(private http_client: HttpClient) { }

  registerAgent(registerAgent: RegisterAgent) {
    this.http_client.post("http://localhost:8080/admin/agent", registerAgent).subscribe();
  }
}
