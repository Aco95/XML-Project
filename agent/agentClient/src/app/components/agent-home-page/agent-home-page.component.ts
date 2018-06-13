import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-agent-home-page',
  templateUrl: './agent-home-page.component.html',
  styleUrls: ['./agent-home-page.component.css']
})
export class AgentHomePageComponent implements OnInit {

  activities : string[];
  panels : boolean[];

  constructor() { }

  ngOnInit() {

    this.activities = ["app-menu__item active", "app-menu__item", "app-menu__item", "app-menu__item", "app-menu__item"];
    this.panels = [true, false, false, false, false];

  }


  switchActiveTab(index : number) {


    for (var i = 0; i < this.activities.length; i++) {
      this.activities[i] = "app-menu__item";
      
    }

    for (var j = 0; j < this.panels.length; j++) {
      this.panels[j] = false;
      
    }

    this.activities[index] = "app-menu__item active";
    this.panels[index] = true;
    
  }

}
