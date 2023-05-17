import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ProfStudentsRoutingModule } from './prof-students-routing.module';
import { ProfStudentsComponent } from './prof-students.component';


@NgModule({
  declarations: [
    ProfStudentsComponent
  ],
  imports: [
    CommonModule,
    ProfStudentsRoutingModule
  ]
})
export class ProfStudentsModule { }
