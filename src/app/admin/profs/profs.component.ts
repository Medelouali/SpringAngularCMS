import { Component } from '@angular/core';
import { ProfsService } from 'src/app/services/profs/profs.service';

@Component({
  selector: 'app-profs',
  templateUrl: './profs.component.html',
  styleUrls: ['./profs.component.css']
})
export class ProfsComponent {
  constructor(public profsService: ProfsService){}

  
  ngOnInit(): void {
    this.profsService.fetchProfs();
  }
}
