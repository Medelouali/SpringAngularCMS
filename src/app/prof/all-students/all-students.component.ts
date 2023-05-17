import { Component } from '@angular/core';
import { StudentsService } from 'src/app/services/students/students.service';

@Component({
  selector: 'app-all-students',
  templateUrl: './all-students.component.html',
  styleUrls: ['./all-students.component.css']
})
export class AllStudentsComponent {
  constructor(public studentsService: StudentsService){}

  ngOnInit(): void {
    this.studentsService.fetchStudents();
  }
}
