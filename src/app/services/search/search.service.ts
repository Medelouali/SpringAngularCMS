import { SearchResponse } from 'src/app/utils/types/SearchResponse';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject, Observable, Observer } from 'rxjs';
import { tap } from 'rxjs/operators';
import { User } from 'src/app/utils/types/User';
import { baseUrl } from 'src/app/utils/others/constants';

@Injectable({
  providedIn: 'root'
})
export class SearchService {
  private searchResults: BehaviorSubject<SearchResponse> = new BehaviorSubject<SearchResponse>(new SearchResponse());
  searchResults$: Observable<SearchResponse> = this.searchResults.asObservable();
  isLoading = false;
  errorMessage = '';

  constructor(private http: HttpClient) { }

  search(query: string): void {
    this.isLoading = true;
    this.http.get<SearchResponse>(`${baseUrl}/api/search/${query}`).pipe(
      tap((data: SearchResponse) => {
        console.log(data);
        this.searchResults.next(data);
        this.isLoading = false;
      })
    ).subscribe();
  }


  getSearchResults(): Observable<SearchResponse>{
    return this.searchResults$;
  }

  getIsLoading(): boolean{
    return this.isLoading;
  }

  getErrorMessage(): string{
    return this.errorMessage;
  }
}
