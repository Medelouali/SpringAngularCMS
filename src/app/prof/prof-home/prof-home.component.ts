import { Component } from '@angular/core';
import { ProfsService } from 'src/app/services/profs/profs.service';

@Component({
  selector: 'app-prof-home',
  templateUrl: './prof-home.component.html',
  styleUrls: ['./prof-home.component.css']
})
export class ProfHomeComponent {
  constructor(public profsService: ProfsService){}

  
  ngOnInit(): void {
    this.profsService.fetchProfs();
  }
}
