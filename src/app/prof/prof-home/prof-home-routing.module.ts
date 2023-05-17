import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ProfHomeComponent } from './prof-home.component';

const routes: Routes = [{ path: '', component: ProfHomeComponent }];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ProfHomeRoutingModule { }
