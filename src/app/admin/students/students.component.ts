import { Component } from '@angular/core';
import { StudentsService } from 'src/app/services/students/students.service';

@Component({
  selector: 'app-students',
  templateUrl: './students.component.html',
  styleUrls: ['./students.component.css']
})
export class StudentsComponent {
  constructor(public studentsService: StudentsService){}

  ngOnInit(): void {
    this.studentsService.fetchStudents();
  }

}
