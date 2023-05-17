package springmvc_ensa.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springmvc_ensa.entities.Admin;
import springmvc_ensa.entities.Mark;
import springmvc_ensa.service.MarkService;

import java.util.List;

@RestController
@RequestMapping("api/marks")
public class MarkController {
    private final MarkService markService;

    @Autowired
    public MarkController(MarkService markService) {
        this.markService = markService;
    }

    @GetMapping
    public ResponseEntity<List<Mark>> getMarks() {
        return new ResponseEntity<>(markService.getMarks(), HttpStatus.OK) ;
    }
}
