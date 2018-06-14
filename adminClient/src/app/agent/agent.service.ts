import {Injectable} from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Agent } from '../models/agent.model';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable()
export class AgentService {
  constructor(private http: HttpClient) {}
 
  private agentUrl = '/api';
  public getAgents(){
    return this.http.get<Agent[]>(this.agentUrl);
  } 
  
  public deleteAgent(agent){
    return this.http.delete(this.agentUrl + "/" + agent.id);
  }
  
  public createAgent(agent){
    return this.http.post<Agent>(this.agentUrl, agent);
  }
}

