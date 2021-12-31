import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BoardMachinistComponent } from './board-machinist.component';

describe('BoardMachinistComponent', () => {
  let component: BoardMachinistComponent;
  let fixture: ComponentFixture<BoardMachinistComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BoardMachinistComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BoardMachinistComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
