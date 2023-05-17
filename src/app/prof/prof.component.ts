import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-prof',
  templateUrl: './prof.component.html',
  styleUrls: ['./prof.component.css']
})
export class ProfComponent {
  isOnNewCourse=false;
  isOnNewStudent=false;
  constructor(private router: Router) { }

  search(query: { query: string }){
    this.router.navigate([`/profs/search/${query.query}`]);
  }

  toggleNewCourse(){
    this.isOnNewCourse=!this.isOnNewCourse;
  }

  toggleNewStudent(){
    this.isOnNewStudent=!this.isOnNewStudent;
  }

  toggleNewCourseCb(cb: void){
    this.toggleNewCourse();
  }
  toggleNewStudentCb(cb: void){
    this.toggleNewStudent();
  }
}
