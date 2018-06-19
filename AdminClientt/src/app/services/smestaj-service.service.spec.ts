import { TestBed, inject } from '@angular/core/testing';

import { SmestajServiceService } from './smestaj-service.service';

describe('SmestajServiceService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [SmestajServiceService]
    });
  });

  it('should be created', inject([SmestajServiceService], (service: SmestajServiceService) => {
    expect(service).toBeTruthy();
  }));
});
