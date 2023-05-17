import { Component } from '@angular/core';
import { CoursesService } from 'src/app/services/courses/courses.service';

@Component({
  selector: 'app-student-courses',
  templateUrl: './student-courses.component.html',
  styleUrls: ['./student-courses.component.css']
})
export class StudentCoursesComponent {
  constructor(public coursesService: CoursesService) { }

  ngOnInit(): void {
    this.coursesService.fetchMyCourses();
  }
}
