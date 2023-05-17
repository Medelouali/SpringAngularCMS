import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { NewProfRoutingModule } from './new-prof-routing.module';
import { NewProfComponent } from './new-prof.component';
import { FormsModule } from '@angular/forms';


@NgModule({
  declarations: [
    NewProfComponent
  ],
  imports: [
    CommonModule,
    NewProfRoutingModule,
    FormsModule
  ],
  exports: [
    NewProfComponent
  ]
})
export class NewProfModule { }
