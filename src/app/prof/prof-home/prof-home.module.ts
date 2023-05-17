import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ProfHomeRoutingModule } from './prof-home-routing.module';
import { ProfHomeComponent } from './prof-home.component';


@NgModule({
  declarations: [
    ProfHomeComponent
  ],
  imports: [
    CommonModule,
    ProfHomeRoutingModule
  ]
})
export class ProfHomeModule { }
