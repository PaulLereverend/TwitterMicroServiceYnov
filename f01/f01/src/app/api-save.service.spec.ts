import { TestBed } from '@angular/core/testing';

import { ApiSaveService } from './api-save.service';

describe('ApiSaveService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: ApiSaveService = TestBed.get(ApiSaveService);
    expect(service).toBeTruthy();
  });
});
