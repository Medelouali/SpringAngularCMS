import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ProfStudentsComponent } from './prof-students.component';

const routes: Routes = [{ path: '', component: ProfStudentsComponent }];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ProfStudentsRoutingModule { }
