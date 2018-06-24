import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import {debounceTime} from 'rxjs/operators';
import {Subject} from 'rxjs';

import { RezervacijeService } from '../../services/rezervacije.service';
import { AuthServiceService} from '../../services/auth-service.service';


@Component({
  selector: 'app-messages',
  templateUrl: './messages.component.html',
  styleUrls: ['./messages.component.css']
})
export class MessagesComponent implements OnInit {


  inboxSent : string[];
  msgPanels : boolean[];
  agents : any[];

  inbox : any[] = [];
  sent : any[] = [];
  unread : number;
  clickedIndex : number;

  messageSubject : string;
  messageContent : string;
  messageRecipient : string;

  private currentClient: any;
  private currentAgent: any;

  listAgenataPrimljene : any[] = [];
  listAgenataPoslate : any[] = [];

  constructor(private router : Router, private rezervacijeService: RezervacijeService, private authService:AuthServiceService) { }

  ngOnInit() {


    this.currentClient = this.authService.getUser();
    console.log(this.currentClient);

    
    this.inboxSent = ["nav-link active", "nav-link", "nav-link"];
    this.msgPanels = [true, false, false, false];
    this.unread = 0;
    this.getInbox();
    this.getSent();
    this.getClients();
  }



  switchInboxSent(index : number) {

    for (var i = 0; i < this.inboxSent.length; i++) {
      this.inboxSent[i] = "nav-link";
      
    }

    for (var j = 0; j < this.msgPanels.length; j++) {
      this.msgPanels[j] = false;
      
    }

    this.inboxSent[index] = "nav-link active";
    this.msgPanels[index] = true;

    this.messageRecipient = "";
    this.messageContent = "";
    this.messageSubject = "";
  }


  getInbox() {


    this.rezervacijeService.getInbox().subscribe(data=> { 
      this.inbox = data;
      for(let message of data){
        this.rezervacijeService.getUserById(message.idAgenta)
          .subscribe(user => {
            this.unread = 0;
            this.getUnreadMessages(data); 
            this.listAgenataPrimljene.push(user);
          });
      }
      console.log(data)
    });

  }

  getSent() {


    this.rezervacijeService.getSent().subscribe(data=> { 
      this.sent = data;
      for(let message of this.sent){
        this.rezervacijeService.getUserById(message.idAgenta)
          .subscribe(user => {
            
            this.listAgenataPoslate.push(user);
          });
      }
      console.log(data)
    });

  }

  getUnreadMessages(msgs : any) {

    for (let msg of msgs) {
      
      if (!msg.procitana)
        this.unread++;

    }
  }

  // detaljniji prikaz primljene poruke
  markAsReadInbox(index : number) {

    if (!this.inbox[index].procitana) {

      this.inbox[index].procitana = true;
      this.unread--;

    }

    this.msgPanels[3] = true;
    this.msgPanels[0] = false;
    this.inboxSent[0] = "nav-link";

    this.messageRecipient = this.listAgenataPrimljene[index].username;
    this.messageSubject = this.inbox[index].naslov;
    this.messageContent = this.inbox[index].sadrzaj;

    // this.rezervacijeService.getUserByUsername(this.inbox[index].idAgenta)
    // .subscribe(data => {
    //   this.messageRecipient = data.username;    
      
    //   } 
    // );
    
      
  }

  sendMessage() {

    let agentID : string;

    for (let user of this.listAgenataPrimljene) {

        if (user.username == this.messageRecipient) {

          agentID = user.id;

        }


    }
    

    this.rezervacijeService.sendMessage({idKlijenta : this.currentClient.id, idAgenta : agentID, naslov : this.messageSubject, sadrzaj : this.messageContent, procitana : false, primljena : false}).subscribe(data => {

      console.log(data);
      this.getSent(); 
      this. msgPanels[2] = false;
      this. msgPanels[4] = false;
      this. msgPanels[5] = false;
      this.inboxSent[2] = "nav-link"; 
      this.msgPanels[1] = true;    
      this.inboxSent[1] = "nav-link active"; 

      this.messageRecipient = "";
      this.messageSubject = "";
      this.messageContent = "";

    });
      
     
 

  }

  getClients() {


    this.rezervacijeService.getAgenti().subscribe(data=> { this.agents = data; console.log(data)});

  }

  //podesava izgled poruke za slanje
  reply() {

    this.msgPanels[3] = false;
    this.msgPanels[5] = false;
    this.msgPanels[4] = true;
    
    this.messageContent = "";
  }

  //detaljniji prikaz poslate poruke
  openSentMessage(index : number) {

    this.msgPanels[1] = false;    
    this.inboxSent[1] = "nav-link"; 
    this.msgPanels[5] = true;

    this.messageRecipient = this.listAgenataPoslate[index].username;
    this.messageSubject = this.sent[index].naslov;
    this.messageContent = this.sent[index].sadrzaj;
  }

}
