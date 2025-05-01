import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BarDeNavigationComponent } from './bar-de-navigation.component';

describe('BarDeNavigationComponent', () => {
  let component: BarDeNavigationComponent;
  let fixture: ComponentFixture<BarDeNavigationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [BarDeNavigationComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(BarDeNavigationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
