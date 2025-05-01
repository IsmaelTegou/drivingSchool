import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InstructorComponent } from './instructor.component';

describe('TablesComponent', () => {
  let component: InstructorComponent;
  let fixture: ComponentFixture<InstructorComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [InstructorComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(InstructorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
