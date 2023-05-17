import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AdminRoutingModule } from './admin-routing.module';
import { AdminComponent } from './admin.component';
import { NewCourseModule } from './new-course/new-course.module';
import { NewProfModule } from './new-prof/new-prof.module';
import { NewAdminModule } from './new-admin/new-admin.module';
import { NewStudentModule } from './new-student/new-student.module';
import { FormsModule } from '@angular/forms';


@NgModule({
  declarations: [
    AdminComponent
  ],
  imports: [
    CommonModule,
    AdminRoutingModule,
    
    NewCourseModule,
    NewProfModule,
    NewAdminModule,
    NewStudentModule,
    FormsModule
  ],
  exports: [AdminComponent]
})
export class AdminModule { }
