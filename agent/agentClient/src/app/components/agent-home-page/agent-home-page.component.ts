import { Component, OnInit } from '@angular/core';

import {NgbRatingConfig} from '@ng-bootstrap/ng-bootstrap';

import {SmestajService} from '../../services/smestaj.service';

import {PorukaService} from '../../services/poruka.service';

import {KorisnikService} from '../../services/korisnik.service';

import {RezervacijaService} from '../../services/rezervacija.service';

import {SobaService} from '../../services/soba.service';

import {debounceTime} from 'rxjs/operators';
import {Subject} from 'rxjs';

@Component({
  selector: 'app-agent-home-page',
  templateUrl: './agent-home-page.component.html',
  styleUrls: ['./agent-home-page.component.css'],
  providers: [NgbRatingConfig]
})
export class AgentHomePageComponent implements OnInit {

  activities : string[];
  panels : boolean[];
  accommodations : any[];
  inboxSent : string[];
  msgPanels : boolean[];
  clients : any[];
  reservations : any[];
  reservationsEarnings : any[] = [];
  showSuccessNotification : boolean;
  showErrorNotification : boolean;

  accommodationName : string;
  accommodationAddress : string;
  accommodationCity : string;
  accommodationDescription : string;
  accommodationImage : string;
  accommodationType : string;
  accommodationSingleRooms : number;
  accommodationDoubleRooms : number;
  accommodationTripleRooms : number;
  accommodationQuadRooms : number;
  accommodationWIFI : boolean = false;
  accommodationPARKING : boolean = false;
  accommodationTV : boolean = false;
  accommodationBREAKFAST : boolean = false;
  accommodationBOARDING_HOUSE : boolean = false;
  accommodationHALF_BOARD : boolean = false;
  accommodationSMALL_KITCHEN : boolean = false;
  accommodationPRIVATE_BATHROOM : boolean = false;
  accommodationCategory : number;

  inbox : any[] = [];
  sent : any[] = [];
  unread : number;
  clickedIndex : number;
  roomNo : number;

  messageSubject : string;
  messageContent : string;
  messageRecipient : string;

  dateFrom : any;
  dateTo: any;

  minDateFrom : any;
  minDateTo : any;

  staticAlertClosed : boolean = false;

  constructor(private smestajService : SmestajService, private porukaService : PorukaService, 
              private rezervacijaService : RezervacijaService, private korisnikService : KorisnikService,
              private sobaService : SobaService, config: NgbRatingConfig) { 
                
                
                config.max = 5;
              
                
              }

  ngOnInit() { 

    this.activities = ["app-menu__item active", "app-menu__item", "app-menu__item", "app-menu__item", "app-menu__item"];
    this.panels = [true, false, false, false, false, false, false];
    this.inboxSent = ["nav-link active", "nav-link", "nav-link"];
    this.msgPanels = [true, false, false, false];
    this.unread = 0;
    this.roomNo = 0;
    this.showSuccessNotification = false;
    this.showErrorNotification = false;
    this.minDateFrom = {year: 0, month: 0, day: 0};
    this.minDateTo = {year: 0, month: 0, day: 0};
    this.getAccomodations();
    this.accommodationType = "HOTEL";
    this.getInbox();
    this.getSent();
    this.getClients();
    this.getReservations();

  
    
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

    if (index == 0 ) {

      this.getAccomodations();

    } else if (index == 3) {


      this.getInbox();
    }

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
  }

  getAccomodations() {


    this.smestajService.getSmestaji().subscribe(data=> { 
      
      this.accommodations = data;
      console.log(data);
      
      var today = new Date();
      this.minDateFrom.year = today.getFullYear();
      this.minDateFrom.month = today.getMonth() + 1;
      this.minDateFrom.day = today.getDate();
      
    });

  }

  updateFile(file: HTMLInputElement) {
    let name = file.value;
    let parts = name.split("\\");
    this.accommodationImage = parts[parts.length - 1];
    console.log(name);
    console.log(this.accommodationImage);
  }

  insertNewAccommodation() {

    let slike : string[] = [];
    slike[0] = "../../../assets/images/" + this.accommodationImage;

    this.smestajService.insertAccommodation({slikeUrl : slike, naziv : this.accommodationName, adresa : this.accommodationAddress, 
                                             mesto : this.accommodationCity, kategorija : this.accommodationCategory,
                                             tip : this.accommodationType, parking : this.accommodationPARKING,
                                             wifi : this.accommodationWIFI, dorucak : this.accommodationBREAKFAST,
                                             polupansion : this.accommodationHALF_BOARD, pansion : this.accommodationBOARDING_HOUSE,
                                             tv : this.accommodationTV, miniKuhinja : this.accommodationSMALL_KITCHEN,
                                             privatnoKupatilo : this.accommodationPRIVATE_BATHROOM, ocena : 0,
                                             opis : this.accommodationDescription, brJednokrevetnih : this.accommodationSingleRooms,
                                             brDvokrevetnih : this.accommodationDoubleRooms, brTrokrevetnih : this.accommodationTripleRooms,
                                             brCetvorokrevetnih : this.accommodationQuadRooms}).subscribe(data => {
      
      
      
      console.log(data);

    });


  }

  getInbox() {


    this.porukaService.getInbox().subscribe(data=> { this.inbox = data;this.unread = 0; this.getUnreadMessages(data); console.log(data)});

  }

  getSent() {


    this.porukaService.getSent().subscribe(data=> { this.sent = data; console.log(data)});

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

    this.messageRecipient = this.inbox[index].sagovornik.username;
    this.messageSubject = this.inbox[index].naslov;
    this.messageContent = this.inbox[index].sadrzaj;
      
  }

  sendMessage() {

   
 
    this.porukaService.send({procitana : false, sagovornik : this.messageRecipient, naslov : this.messageSubject,
                             sadrzaj : this.messageContent, primljena : false}).subscribe(data => {



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


    this.korisnikService.getKorisnici().subscribe(data=> { this.clients = data; console.log(data)});

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

    this.messageRecipient = this.sent[index].sagovornik.username;
    this.messageSubject = this.sent[index].naslov;
    this.messageContent = this.sent[index].sadrzaj;
  }

  getReservations() {


    this.rezervacijaService.getRezervacije().subscribe(data=> { this.reservations = data; this.calculateEarningsOfReservations(data); console.log(data)});

  }

  calculateEarningsOfReservations(reservations : any) {

        for (let reservation of reservations) {
      
          var diff = Math.abs(new Date(reservation._do).getTime()- new Date(reservation.od).getTime());
          let days = Math.ceil(diff / (1000 * 3600 * 24)); 
          let earning = days * reservation.soba.cena;
          this.reservationsEarnings.push(earning);
        }
  }

  markAsRealized(index : number) {

    this.reservations[index].realizacija = "REALIZED";

    this.rezervacijaService.changeRealization(this.reservations[index]).subscribe(data => {
        
    });

  }

  markAsUnrealized(index : number) {

    this.reservations[index].realizacija = "UNREALIZED";

    this.rezervacijaService.changeRealization(this.reservations[index]).subscribe(data => {
        
    });
  }

  setNewSchedule(accommodation : any) {
    
    

    if (this.dateFrom.month < 10) {

      this.dateFrom.month = "0" + this.dateFrom.month;
    }

    if (this.dateTo.month < 10) {

      this.dateTo.month = "0" + this.dateTo.month;
    }

    if (this.dateFrom.day < 10) {

      this.dateFrom.day = "0" + this.dateFrom.day;
    }

    if (this.dateTo.day < 10) {

      this.dateTo.day = "0" + this.dateTo.day;
    }
    
    
    let roomForChanging : any;
    let fromConverted = this.dateFrom.year + "-" + this.dateFrom.month + "-" + this.dateFrom.day;
    let toConverted = this.dateTo.year + "-" + this.dateTo.month + "-" + this.dateTo.day;

    for (let room of accommodation.sobe) {
      
      if (room.broj == this.roomNo) {

        roomForChanging = room;
        break;

      }
    }
    this.sobaService.changeSchedule({soba : roomForChanging, from : fromConverted, to : toConverted}).subscribe(data => {
        
      
      this.getAccomodations();

      if (data) {

        this.showSuccessNotification = true;
        this.showErrorNotification = false;

        setTimeout(() => this.showSuccessNotification = false, 5000);

      } else {

        this.showErrorNotification = true;
        this.showSuccessNotification = false;

        setTimeout(() => this.showErrorNotification = false, 5000);
      }
    });

  }

  setMinDateTo() {

    this.minDateTo = this.dateFrom;

  }

}
