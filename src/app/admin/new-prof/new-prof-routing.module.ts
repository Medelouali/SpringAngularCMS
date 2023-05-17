import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { NewProfComponent } from './new-prof.component';

const routes: Routes = [{ path: '', component: NewProfComponent }];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class NewProfRoutingModule { }
