import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { NewStudentRoutingModule } from './new-student-routing.module';
import { NewStudentComponent } from './new-student.component';
import { FormsModule } from '@angular/forms';


@NgModule({
  declarations: [
    NewStudentComponent
  ],
  imports: [
    CommonModule,
    NewStudentRoutingModule,
    FormsModule
  ],
  exports: [
    NewStudentComponent
  ]
})
export class NewStudentModule { }
