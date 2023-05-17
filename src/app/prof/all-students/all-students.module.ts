import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AllStudentsRoutingModule } from './all-students-routing.module';
import { AllStudentsComponent } from './all-students.component';


@NgModule({
  declarations: [
    AllStudentsComponent
  ],
  imports: [
    CommonModule,
    AllStudentsRoutingModule
  ]
})
export class AllStudentsModule { }
