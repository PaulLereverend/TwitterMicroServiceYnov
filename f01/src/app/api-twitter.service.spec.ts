import { TestBed } from '@angular/core/testing';

import { ApiTwitterService } from './api-twitter.service';

describe('ApiTwitterService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: ApiTwitterService = TestBed.get(ApiTwitterService);
    expect(service).toBeTruthy();
  });
});
