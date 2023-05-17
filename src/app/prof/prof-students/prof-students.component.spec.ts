import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProfStudentsComponent } from './prof-students.component';

describe('ProfStudentsComponent', () => {
  let component: ProfStudentsComponent;
  let fixture: ComponentFixture<ProfStudentsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ProfStudentsComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ProfStudentsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
