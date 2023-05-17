import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent {
  isOnNewCourse=false;
  isOnNewAdmin=false;
  isOnNewProf=false;
  isOnNewStudent=false;

  constructor(private router: Router) { }

  search(query: { query: string }){
    this.router.navigate([`/students/search/${query.query}`]);
  }

  toggleNewCourse(){
    this.isOnNewCourse=!this.isOnNewCourse;
  }

  toggleNewAdmin(){
    this.isOnNewAdmin=!this.isOnNewAdmin;
  }

  toggleNewProf(){
    this.isOnNewProf=!this.isOnNewProf;
  }

  toggleNewStudent(){
    this.isOnNewStudent=!this.isOnNewStudent;
  }

  toggleNewCourseCb(cb: void){
    this.toggleNewCourse();
  }
  toggleNewAdminCb(cb: void){
    this.toggleNewAdmin();
  }
  toggleNewStudentCb(cb: void){
    this.toggleNewStudent();
  }
  toggleNewProfCb(cb: void){
    this.toggleNewProf();
  }

  
}
