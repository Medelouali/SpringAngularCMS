import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminComponent } from './admin.component';

const routes: Routes = [
  { path: '', component: AdminComponent ,
    children: [
      { path: 'profs', loadChildren: () => import('./profs/profs.module').then(m => m.ProfsModule) }, 
      { path: 'students', loadChildren: () => import('./students/students.module').then(m => m.StudentsModule) }, 
      { path: 'courses', loadChildren: () => import('./courses/courses.module').then(m => m.CoursesModule) }, 
      { path: 'admin-home', loadChildren: () => import('./admin-home/admin-home.module').then(m => m.AdminHomeModule) },
      { path: 'search/:query', loadChildren: () => import('./search/search.module').then(m => m.SearchModule) },
      { path: '**', loadChildren: () => import('./admin-home/admin-home.module').then(m => m.AdminHomeModule) }
    ]
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AdminRoutingModule { }
