import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NewPlanningComponent } from './new-planning.component';

describe('NewPlanningComponent', () => {
  let component: NewPlanningComponent;
  let fixture: ComponentFixture<NewPlanningComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [NewPlanningComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(NewPlanningComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
