import { TestBed } from '@angular/core/testing';

import { SuiviATService } from './suivi-at.service';

describe('SuiviATService', () => {
  let service: SuiviATService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SuiviATService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
