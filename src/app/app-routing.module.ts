import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AppComponent } from './app.component';
import { AdminGuard } from './guards/admin.guard';
import { StudentGuard } from './guards/student.guard';
import { ProfGuard } from './guards/prof.guard';

const routes: Routes = [
  { path: "",
    children:[
      { 
        path: 'home', 
        loadChildren: () => import('./home/home.module').then(m => m.HomeModule) 
      },
      { 
        path: 'admins', 
        loadChildren: () => import('./admin/admin.module').then(m => m.AdminModule),
        canActivate: [ AdminGuard ]
      },
      { 
        path: 'students', 
        loadChildren: () => import('./student/student.module').then(m => m.StudentModule),
        canActivate: [ StudentGuard ] 
      },
      { 
        path: 'profs', 
        loadChildren: () => import('./prof/prof.module').then(m => m.ProfModule),
        canActivate: [ ProfGuard ] 
      },
      { 
        path: "**", 
        loadChildren: () => import('./home/home.module').then(m => m.HomeModule)
      }
    ]
  },
  ];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
