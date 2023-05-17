import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ProfComponent } from './prof.component';

const routes: Routes = [
  { path: '', component: ProfComponent,
    children: [
      { path: 'all-students', loadChildren: () => import('./all-students/all-students.module').then(m => m.AllStudentsModule) }, 
      { path: 'prof-students', loadChildren: () => import('./prof-students/prof-students.module').then(m => m.ProfStudentsModule) }, 
      { path: 'prof-home', loadChildren: () => import('./prof-home/prof-home.module').then(m => m.ProfHomeModule) },
      { path: 'search/:query', loadChildren: () => import('./search/search.module').then(m => m.SearchModule) },
      { path: '**', loadChildren: () => import('./prof-home/prof-home.module').then(m => m.ProfHomeModule) },

    ]
  },
 
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ProfRoutingModule { }
