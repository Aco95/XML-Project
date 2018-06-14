import { TestBed, inject } from '@angular/core/testing';

import { SmestajService } from './smestaj.service';

describe('SmestajService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [SmestajService]
    });
  });

  it('should be created', inject([SmestajService], (service: SmestajService) => {
    expect(service).toBeTruthy();
  }));
});
