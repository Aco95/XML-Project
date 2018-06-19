import { Component, OnInit, Inject } from '@angular/core';
import { FormBuilder, FormGroup, Validators, FormControl } from '@angular/forms';
import { RegisterAgent } from '../../models/register-agent';
import { RegisterAgentService } from "../../services/register-agent.service";

@Component({
  selector: 'app-register-agent',
  templateUrl: './register-agent.component.html',
  styleUrls: ['./register-agent.component.css']
})
export class RegisterAgentComponent implements OnInit {
  form: FormGroup;
  agent: RegisterAgent;

  constructor(@Inject(FormBuilder) formBuilder: FormBuilder, private registerAgentService: RegisterAgentService) {
    this.form = formBuilder.group({
      ime: new FormControl("", [Validators.required]),
      prezime: new FormControl("", [Validators.required]),
      adresa: new FormControl("", [Validators.required]),
      maticniBroj: new FormControl("", [Validators.required, Validators.pattern("[0-9]{3}")]),
      email: new FormControl("", [Validators.required, Validators.email]),
      password: new FormControl("", [Validators.required])

    });
  }

  ngOnInit() {
  }

  submit(event: any) {
    this.agent = this.form.value;
    this.registerAgentService.registerAgent(this.agent);
    this.form.reset();
  }
}
