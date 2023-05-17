import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject, Observable, Observer } from 'rxjs';
import { tap } from 'rxjs/operators';
import { User } from 'src/app/utils/types/User';
import { baseUrl } from 'src/app/utils/others/constants';

@Injectable({
  providedIn: 'root'
})
export class ProfsService {
  private profs: BehaviorSubject<User[]> = new BehaviorSubject<User[]>([]);
  profs$: Observable<User[]> = this.profs.asObservable();
  isLoading = false;
  errorMessage = '';

  constructor(private http: HttpClient) { }

  fetchProfs(): void {
    this.isLoading = true;
    this.http.get<User[]>(`${baseUrl}/api/profs`).pipe(
      tap((data: User[]) => {
        console.log(data);
        this.profs.next(data);
        this.isLoading = false;
      })
    ).subscribe();
  }

  addProf(prof: User): void {
    this.isLoading = true;
    this.http.post<User>(`${baseUrl}/api/profs`, prof).pipe(
      tap((data: User) => {
        console.log(data);
        this.isLoading = false;
        alert(`Mr ${data.username} has has been saved successfully as PROF`)
      })
    ).subscribe();
  }

  deleteProf(profId: number): void {
    this.isLoading = true;
    this.http.delete<User>(`${baseUrl}/api/profs/${profId}`).pipe(
      tap((data: User) => {
        console.log(data);
        // this.admins.next(data);
        alert(`Mr ${data.username} has been deleted successfully`)
        this.isLoading = false;
      })
    ).subscribe();
  }

  getProfs(): Observable<Array<User>>{
    return this.profs$;
  }

  getIsLoading(): boolean{
    return this.isLoading;
  }

  getErrorMessage(): string{
    return this.errorMessage;
  }
}
