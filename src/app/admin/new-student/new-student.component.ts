import { Component, EventEmitter, Output } from '@angular/core';
import { StudentsService } from 'src/app/services/students/students.service';

@Component({
  selector: 'app-new-student',
  templateUrl: './new-student.component.html',
  styleUrls: ['./new-student.component.css']
})
export class NewStudentComponent {
  @Output() dipatchCancelStudent: EventEmitter<void> = new EventEmitter<void>();
  constructor(public studentsService: StudentsService){}

  cancelStudent(){
    this.dipatchCancelStudent.emit();
  }

  addStudent(user: {username: string, email: string, description: string}){
    console.log(user);
    this.studentsService.addStudent(user);
  }
}
