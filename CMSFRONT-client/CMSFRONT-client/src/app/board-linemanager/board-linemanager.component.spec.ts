import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BoardLinemanagerComponent } from './board-linemanager.component';

describe('BoardLinemanagerComponent', () => {
  let component: BoardLinemanagerComponent;
  let fixture: ComponentFixture<BoardLinemanagerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BoardLinemanagerComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BoardLinemanagerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
