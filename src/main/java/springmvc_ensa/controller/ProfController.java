package springmvc_ensa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springmvc_ensa.entities.Admin;
import springmvc_ensa.entities.Prof;
import springmvc_ensa.entities.Student;
import springmvc_ensa.helpers.dtos.NewUserDto;
import springmvc_ensa.service.ProfService;
import springmvc_ensa.service.UserService;

import java.util.List;

@RestController
@RequestMapping("api/profs")
public class ProfController {
    private final ProfService profService;
    private final UserService userService;

    @Autowired
    public ProfController(ProfService profService, UserService userService) {
        this.profService = profService;
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<Prof>> getProfs() {
        System.out.println("Props Hit");
        return new ResponseEntity<>(this.profService.getProfs(), HttpStatus.OK) ;
    }

    @GetMapping("/{profId}/my-students")
    public ResponseEntity<List<Student>> getMyStudents(@PathVariable Long profId) {
        System.out.println("Props Hit");
        return new ResponseEntity<>(this.profService.getMyStudents(profId), HttpStatus.OK) ;
    }

    @PostMapping
    public ResponseEntity<Prof> addProf(@RequestBody NewUserDto newUserDto){
        System.out.println("Got here");
        return new ResponseEntity<>(this.userService.addProf(newUserDto), HttpStatus.OK);
    }

    @PostMapping("/{profId}/assignTo/{studentId}")
    public ResponseEntity<Prof> assignProfToStudent(@PathVariable Long profId, @PathVariable Long studentId){
        System.out.println("Got here");
        return new ResponseEntity<>(this.profService.assignProfToStudent(profId, studentId), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Prof> deleteProf(@PathVariable long id){
        return new ResponseEntity<>(this.profService.deleteProf(id), HttpStatus.OK);
    }

}
