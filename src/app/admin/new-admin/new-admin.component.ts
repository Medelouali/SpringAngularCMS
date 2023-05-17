import { Component, EventEmitter, Output } from '@angular/core';
import { AdminsService } from 'src/app/services/admins/admins.service';

@Component({
  selector: 'app-new-admin',
  templateUrl: './new-admin.component.html',
  styleUrls: ['./new-admin.component.css']
})
export class NewAdminComponent {
  @Output() dipatchCancelAdmin: EventEmitter<void> = new EventEmitter<void>();
  constructor(public adminsService: AdminsService){}

  cancelAdmin(){
    this.dipatchCancelAdmin.emit();
  }

  addAdmin(user: {username: string, email: string, description: string}){
    console.log(user);
    this.adminsService.addAdmin(user);
  }
}
