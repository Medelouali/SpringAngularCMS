import { Component } from '@angular/core';
import { AdminsService } from 'src/app/services/admins/admins.service';

@Component({
  selector: 'app-admin-home',
  templateUrl: './admin-home.component.html',
  styleUrls: ['./admin-home.component.css']
})
export class AdminHomeComponent {
  constructor(public adminsService: AdminsService) { }

  ngOnInit(): void {
    this.adminsService.fetchAdmins();
  }
}
