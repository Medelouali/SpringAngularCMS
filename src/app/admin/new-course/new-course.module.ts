import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { NewCourseRoutingModule } from './new-course-routing.module';
import { NewCourseComponent } from './new-course.component';
import { FormsModule } from '@angular/forms';


@NgModule({
  declarations: [
    NewCourseComponent
  ],
  imports: [
    CommonModule,
    NewCourseRoutingModule,
    FormsModule
  ],
  exports: [
    NewCourseComponent
  ]
})
export class NewCourseModule { }
