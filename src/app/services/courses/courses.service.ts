import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject, Observable, Observer } from 'rxjs';
import { tap } from 'rxjs/operators';
import { baseUrl } from 'src/app/utils/others/constants';
import { Course } from 'src/app/utils/types/Course';

@Injectable({
  providedIn: 'root'
})
export class CoursesService {
  private courses: BehaviorSubject<Course[]> = new BehaviorSubject<Course[]>([]);
  courses$: Observable<Course[]> = this.courses.asObservable();

  private myCourses: BehaviorSubject<Course[]> = new BehaviorSubject<Course[]>([]);
  myCourses$: Observable<Course[]> = this.myCourses.asObservable();

  isLoading = false;
  errorMessage = '';
  myId=1;

  constructor(private http: HttpClient) { }

  fetchCourses(): void {
    this.isLoading = true;
    this.http.get<Course[]>(`${baseUrl}/api/courses`).pipe(
      tap((data: Course[]) => {
        console.log(data);
        this.courses.next(data);
        this.isLoading = false;
      })
    ).subscribe();
  }

  addCourse(prof: Course): void {
    this.isLoading = true;
    this.http.post<Course>(`${baseUrl}/api/courses`, prof).pipe(
      tap((data: Course) => {
        console.log(data);
        this.isLoading = false;
        alert(`The course ${data.name} has has been saved successfully, enjoy;)`)
      })
    ).subscribe();
  }
  
  fetchMyCourses(): void {
    this.isLoading = true;
    this.http.get<Course[]>(`${baseUrl}/api/students/${this.myId}/my-courses`).pipe(
      tap((data: Course[]) => {
        console.log(data);
        this.myCourses.next(data);
        this.isLoading = false;
      })
    ).subscribe();
  }

  deleteCourse(courseId: number): void {
    this.isLoading = true;
    this.http.delete<Course>(`${baseUrl}/api/courses/${courseId}`).pipe(
      tap((data: Course) => {
        console.log(data);
        // this.admins.next(data);
        alert(`Mr ${data.name} has been deleted successfully`)
        this.isLoading = false;
      })
    ).subscribe();
  }

  getCourses(): Observable<Array<Course>>{
    return this.courses$;
  }

  getMyCourses(): Observable<Array<Course>>{
    return this.myCourses$;
  }

  getIsLoading(): boolean{
    return this.isLoading;
  }

  getErrorMessage(): string{
    return this.errorMessage;
  }
}
