import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { StudentCoursesComponent } from './student-courses.component';

const routes: Routes = [{ path: '', component: StudentCoursesComponent }];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class StudentCoursesRoutingModule { }
