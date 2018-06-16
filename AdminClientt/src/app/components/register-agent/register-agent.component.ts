import { Component, OnInit, Inject } from '@angular/core';
import { FormBuilder, FormGroup, Validators, FormControl } from '@angular/forms';
import { RegisterAgent } from '../../entities/register-agent';

@Component({
  selector: 'app-register-agent',
  templateUrl: './register-agent.component.html',
  styleUrls: ['./register-agent.component.css']
})
export class RegisterAgentComponent implements OnInit {
  form: FormGroup;
  agent: RegisterAgent;
  constructor(@Inject(FormBuilder) formBuilder: FormBuilder) {
    this.form = formBuilder.group({
      ime: new FormControl("", [Validators.required]),
      prezime: new FormControl("", [Validators.required]),
      adresa: new FormControl("", [Validators.required]),
      maticni_broj: new FormControl("", [Validators.required, Validators.pattern("[0-9]{3}")])
    });
  }

  ngOnInit() {
  }

  submit(event: any) {
    this.agent = this.form.value;
    alert(JSON.stringify(this.form.value));
    this.form.reset();
  }
}
