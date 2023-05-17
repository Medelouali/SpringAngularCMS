package springmvc_ensa.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springmvc_ensa.entities.Admin;
import springmvc_ensa.entities.Course;
import springmvc_ensa.helpers.dtos.NewCourse;
import springmvc_ensa.service.CourseService;

import java.util.List;

@RestController
@RequestMapping("api/courses")
public class CourseController {
    private final CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public ResponseEntity<List<Course>> getCourses() {
        return new ResponseEntity<>(courseService.getCourses(), HttpStatus.OK) ;
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Course> deleteCourse(@PathVariable long id){
        return new ResponseEntity<>(this.courseService.deleteCourse(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Course> addCourse(@RequestBody NewCourse newCourse){
        return new ResponseEntity<>(this.courseService.addCourse(newCourse), HttpStatus.OK);
    }

    @PostMapping("/{studentId}/join/{courseId}")
    public ResponseEntity<Course> joinCourse(@PathVariable Long courseId, @PathVariable Long studentId){
        return new ResponseEntity<>(this.courseService.joinCourse(studentId, courseId), HttpStatus.OK);
    }

    @PostMapping("/{courseId}/assignTo/{profId}")
    public ResponseEntity<Course> assignProfToCourse(@PathVariable Long courseId, @PathVariable Long profId){
        return new ResponseEntity<>(this.courseService.assignProfToCourse(profId, courseId), HttpStatus.OK);
    }
}
