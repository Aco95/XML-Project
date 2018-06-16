import { TestBed, inject } from '@angular/core/testing';

import { RegisterAgentService } from './register-agent.service';

describe('RegisterAgentService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [RegisterAgentService]
    });
  });

  it('should be created', inject([RegisterAgentService], (service: RegisterAgentService) => {
    expect(service).toBeTruthy();
  }));
});
