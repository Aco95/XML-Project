import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import {debounceTime} from 'rxjs/operators';
import {Subject} from 'rxjs';
import { RezervacijeService } from '../../services/rezervacije.service';
import { AuthServiceService} from '../../services/auth-service.service';

@Component({
  selector: 'app-send-message',
  templateUrl: './send-message.component.html',
  styleUrls: ['./send-message.component.css']
})
export class SendMessageComponent implements OnInit {

  private messageRecipient : any;
  private messageSubject = "";
  private messageContent = ""


  private currentClient: any;
  private currentAgent: any;

  constructor(private router : Router, private rezervacijeService: RezervacijeService, private authService:AuthServiceService) { }

  ngOnInit() {

    this.currentClient = this.authService.getUser();
    console.log(this.currentClient);


    this.rezervacijeService.currentAgent.subscribe(
      currentAgent => 
      {
        this.currentAgent = currentAgent;
        console.log("current agent from send message: " + currentAgent);

        this.messageRecipient = this.currentAgent.username;

      }
    );


  }

  submitSendMessage(){

    this.rezervacijeService.sendMessage({idKlijenta : this.currentClient.id, idAgenta : this.currentAgent.id, naslov : this.messageSubject, sadrzaj : this.messageContent, procitana : false, primljena : false})
    .subscribe(data =>
      {
        if(data){
          alert("Sent!");
          this.router.navigateByUrl('/messages');       
        }
        else {
          alert("An error has occurred.");
          this.router.navigateByUrl('/send-message');
        }
         
       
      } 
    );

  }

}
