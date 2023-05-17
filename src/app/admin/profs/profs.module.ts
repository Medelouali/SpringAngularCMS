import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ProfsRoutingModule } from './profs-routing.module';
import { ProfsComponent } from './profs.component';


@NgModule({
  declarations: [
    ProfsComponent
  ],
  imports: [
    CommonModule,
    ProfsRoutingModule
  ]
})
export class ProfsModule { }
