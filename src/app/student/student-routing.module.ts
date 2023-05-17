import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { StudentComponent } from './student.component';

const routes: Routes = [
  { path: '', component: StudentComponent,
    children: [
      { path: 'student-home', loadChildren: () => import('./student-home/student-home.module').then(m => m.StudentHomeModule) }, 
      { path: 'student-courses', loadChildren: () => import('./student-courses/student-courses.module').then(m => m.StudentCoursesModule) },
      { path: 'other-courses', loadChildren: () => import('./courses/courses.module').then(m => m.CoursesModule) }, 
      { path: 'search/:query', loadChildren: () => import('./search/search.module').then(m => m.SearchModule) },
      { path: '', loadChildren: () => import('./student-home/student-home.module').then(m => m.StudentHomeModule) }, 
    ]
  },
 ];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class StudentRoutingModule { }
