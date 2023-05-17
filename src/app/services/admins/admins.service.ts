import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject, Observable, Observer } from 'rxjs';
import { tap } from 'rxjs/operators';
import { User } from 'src/app/utils/types/User';
import { baseUrl } from 'src/app/utils/others/constants';

@Injectable({
  providedIn: 'root'
})
export class AdminsService {
  private admins: BehaviorSubject<User[]> = new BehaviorSubject<User[]>([]);
  admins$: Observable<User[]> = this.admins.asObservable();
  isLoading = false;
  errorMessage = '';

  constructor(private http: HttpClient) { }

  fetchAdmins(): void {
    this.isLoading = true;
    this.http.get<User[]>(`${baseUrl}/api/admins`).pipe(
      tap((data: User[]) => {
        console.log(data);
        this.admins.next(data);
        this.isLoading = false;
      })
    ).subscribe();
  }

  addAdmin(admin: User): void {
    this.isLoading = true;
    this.http.post<User>(`${baseUrl}/api/admins`, admin).pipe(
      tap((data: User) => {
        console.log(data);
        this.isLoading = false;
        alert(`Mr ${admin.username} has been saved successfully as an ADMIN`)
      })
    ).subscribe();
  }

  deleteAdmin(adminId: number): void {
    this.isLoading = true;
    this.http.delete<User>(`${baseUrl}/api/admins/${adminId}`).pipe(
      tap((data: User) => {
        console.log(data);
        // this.admins.next(data);
        alert(`Mr ${data.username} has been deleted successfully`)
        this.isLoading = false;
      })
    ).subscribe();
  }

  getAdmins(): Observable<Array<User>>{
    return this.admins$;
  }

  getIsLoading(): boolean{
    return this.isLoading;
  }

  getErrorMessage(): string{
    return this.errorMessage;
  }
}
