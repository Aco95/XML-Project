import { TestBed, inject } from '@angular/core/testing';

import { PorukaService } from './poruka.service';

describe('PorukaService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [PorukaService]
    });
  });

  it('should be created', inject([PorukaService], (service: PorukaService) => {
    expect(service).toBeTruthy();
  }));
});
