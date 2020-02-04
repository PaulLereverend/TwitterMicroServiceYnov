import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SaveTweetComponent } from './save-tweet.component';

describe('SaveTweetComponent', () => {
  let component: SaveTweetComponent;
  let fixture: ComponentFixture<SaveTweetComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SaveTweetComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SaveTweetComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
