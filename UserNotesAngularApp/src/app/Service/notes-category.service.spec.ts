import { TestBed } from '@angular/core/testing';

import { NotesCategoryService } from './notes-category.service';

describe('NotesCategoryService', () => {
  let service: NotesCategoryService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(NotesCategoryService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
