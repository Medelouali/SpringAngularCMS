import { Component, EventEmitter, Output } from '@angular/core';
import { ProfsService } from 'src/app/services/profs/profs.service';

@Component({
  selector: 'app-new-prof',
  templateUrl: './new-prof.component.html',
  styleUrls: ['./new-prof.component.css']
})
export class NewProfComponent {
  @Output() dipatchCancelProf: EventEmitter<void> = new EventEmitter<void>();
  constructor(public profsService: ProfsService){}

  cancelProf(){
    this.dipatchCancelProf.emit();
  }


  addProf(user: {username: string, email: string, description: string}){
    console.log(user);
    this.profsService.addProf(user);
  }
}
