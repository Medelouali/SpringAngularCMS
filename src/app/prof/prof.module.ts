import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ProfRoutingModule } from './prof-routing.module';
import { ProfComponent } from './prof.component';
import { NewStudentModule } from '../admin/new-student/new-student.module';
import { NewCourseModule } from '../admin/new-course/new-course.module';
import { FormsModule } from '@angular/forms';


@NgModule({
  declarations: [
    ProfComponent
  ],
  imports: [
    CommonModule,
    ProfRoutingModule,
    NewStudentModule,
    NewCourseModule,
    FormsModule
  ]
})
export class ProfModule { }
