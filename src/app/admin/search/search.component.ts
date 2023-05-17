import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { SearchService } from 'src/app/services/search/search.service';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent {
  query="";
  constructor(private route: ActivatedRoute, public searchService: SearchService) { }

  ngOnInit() {
    this.route.paramMap.subscribe(params => {
      this.query = params.get('query') ?? "";
      // Call your search function or perform any desired action here
      this.search(this.query);
      this.searchService.search(this.query);
    });

  }

  search(query: string){
    console.log(query);
  }

}
