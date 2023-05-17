import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { NewAdminRoutingModule } from './new-admin-routing.module';
import { NewAdminComponent } from './new-admin.component';
import { FormsModule } from '@angular/forms';


@NgModule({
  declarations: [
    NewAdminComponent
  ],
  imports: [
    CommonModule,
    NewAdminRoutingModule,
    FormsModule
  ],
  exports: [
    NewAdminComponent
  ]
})
export class NewAdminModule { }
