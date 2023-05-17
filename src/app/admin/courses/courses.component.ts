import { Component } from '@angular/core';
import { CoursesService } from 'src/app/services/courses/courses.service';

@Component({
  selector: 'app-courses',
  templateUrl: './courses.component.html',
  styleUrls: ['./courses.component.css']
})
export class CoursesComponent {
  constructor(public coursesService: CoursesService){}

  ngOnInit(): void {
    this.coursesService.fetchCourses();
  }

}
