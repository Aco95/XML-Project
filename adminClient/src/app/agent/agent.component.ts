import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { Agent } from '../models/agent.model';
import { AgentService } from '../agent/agent.service';

@Component({
  selector: 'app-agent',
  templateUrl: './agent.component.html',
  styleUrls: ['./agent.component.css']
})
export class AgentComponent implements OnInit {
  
  constructor(private router: Router, private agentService: AgentService) { }

  agents: Agent[];
  
  ngOnInit() {
     this.agentService.getAgents()
      .subscribe( data => {
        this.agents = data;
      });
  }
  
  deleteAgent(agent: Agent): void{
    this.agentService.deleteAgent(agent)
      .subscribe( data => {
        this.agents = this.agents.filter(u => u !== agent);
      })
  }

}
