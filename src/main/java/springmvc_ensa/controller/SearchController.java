package springmvc_ensa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springmvc_ensa.entities.Admin;
import springmvc_ensa.helpers.dtos.SearchResponse;
import springmvc_ensa.service.SearchService;

import java.util.List;

@RestController
@RequestMapping("api/search")
public class SearchController {
    private final SearchService searchService;

    @Autowired
    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }

    @GetMapping("/{query}")
    public ResponseEntity<SearchResponse> search(@PathVariable String query) {
        return new ResponseEntity<>(searchService.search(query), HttpStatus.OK) ;
    }
}
