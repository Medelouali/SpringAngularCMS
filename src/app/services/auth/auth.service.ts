import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  role: "ADMIN" | "PROF" | "STUDENT" = "STUDENT";

  signIn(role: "ADMIN" | "PROF" | "STUDENT"){
    this.role=role;
  }

  getRole(): "ADMIN" | "PROF" | "STUDENT"{
    return this.role;
  }
}
