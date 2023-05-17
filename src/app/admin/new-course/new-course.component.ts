import { Component, EventEmitter, Input, Output } from '@angular/core';
import { CoursesService } from 'src/app/services/courses/courses.service';

@Component({
  selector: 'app-new-course',
  templateUrl: './new-course.component.html',
  styleUrls: ['./new-course.component.css']
})
export class NewCourseComponent {
  @Output() dipatchCancelCourse: EventEmitter<void> = new EventEmitter<void>();
  constructor(public coursesService: CoursesService){}

  addCourse(course: {name: string, description: string}){
    this.coursesService.addCourse(course);
  }

  cancelCourse(){
    this.dipatchCancelCourse.emit();
  }
}
