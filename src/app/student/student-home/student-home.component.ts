import { Component } from '@angular/core';
import { StudentsService } from 'src/app/services/students/students.service';

@Component({
  selector: 'app-student-home',
  templateUrl: './student-home.component.html',
  styleUrls: ['./student-home.component.css']
})
export class StudentHomeComponent {
  constructor(public studentsService: StudentsService) { }

  ngOnInit(): void {
    this.studentsService.fetchStudents();
  }
}
