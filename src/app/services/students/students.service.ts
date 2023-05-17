import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject, Observable, Observer } from 'rxjs';
import { tap } from 'rxjs/operators';
import { User } from 'src/app/utils/types/User';
import { baseUrl } from 'src/app/utils/others/constants';

@Injectable({
  providedIn: 'root'
})
export class StudentsService {
  private students: BehaviorSubject<User[]> = new BehaviorSubject<User[]>([]);
  students$: Observable<User[]> = this.students.asObservable();
  isLoading = false;
  errorMessage = '';

  constructor(private http: HttpClient) { }

  fetchStudents(): void {
    this.isLoading = true;
    this.http.get<User[]>(`${baseUrl}/api/students`).pipe(
      tap((data: User[]) => {
        console.log(data);
        this.students.next(data);
        this.isLoading = false;
      })
    ).subscribe();
  }

  addStudent(student: User): void {
    this.isLoading = true;
    this.http.post<User>(`${baseUrl}/api/students`, student).pipe(
      tap((data: User) => {
        console.log(data);
        this.isLoading = false;
        alert(`Mr ${data.username} has has been saved successfully as a STUDENT`)
      })
    ).subscribe();
  }

  deleteStudent(studentId: number): void {
    this.isLoading = true;
    this.http.delete<User>(`${baseUrl}/api/students/${studentId}`).pipe(
      tap((data: User) => {
        console.log(data);
        // this.admins.next(data);
        alert(`Mr ${data.username} has been deleted successfully`)
        this.isLoading = false;
      })
    ).subscribe();
  }

  getStudents(): Observable<Array<User>>{
    return this.students$;
  }

  getIsLoading(): boolean{
    return this.isLoading;
  }

  getErrorMessage(): string{
    return this.errorMessage;
  }
}
