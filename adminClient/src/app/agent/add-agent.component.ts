import { Component } from '@angular/core';
import { Router } from '@angular/router';

import { Agent } from '../models/agent.model';
import { AgentService } from '../agent/agent.service';

@Component({
  templateUrl: './add-agent.component.html'
})
export class AddAgentComponent {

  agent: Agent = new Agent();

  constructor(private router: Router, private agentService: AgentService) {

  }

  createAgent(): void {
    this.agentService.createAgent(this.agent)
        .subscribe( data => {
          alert("User created successfully.");
        });

  };
}