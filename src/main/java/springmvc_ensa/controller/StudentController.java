package springmvc_ensa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import springmvc_ensa.entities.Course;
import springmvc_ensa.entities.Prof;
import springmvc_ensa.entities.Student;
import springmvc_ensa.helpers.dtos.NewUserDto;
import springmvc_ensa.service.StudentService;
import springmvc_ensa.service.UserService;

import java.util.List;

@Controller
@RequestMapping("api/students")
public class StudentController {

    private final StudentService studentService;
    private final UserService userService;

    @Autowired
    public StudentController(StudentService studentService, UserService userService) {
        this.studentService = studentService;
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<Student>> getStudents() {
        return new ResponseEntity<>(studentService.getStudents(), HttpStatus.OK) ;
    }

    @PostMapping
    public ResponseEntity<Student> addStudent(@RequestBody NewUserDto newUserDto){
        System.out.println("Got here");
        return new ResponseEntity<>(this.userService.addStudent(newUserDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Student> deleteProf(@PathVariable long id){
        return new ResponseEntity<>(this.studentService.deleteStudent(id), HttpStatus.OK);
    }

    @GetMapping("/{studentId}/my-courses")
    public ResponseEntity<List<Course>> getMyCourses(@PathVariable Long studentId) {
        return new ResponseEntity<>(studentService.getMyCourses(studentId), HttpStatus.OK) ;
    }

    @GetMapping("/{studentId}/my-profs")
    public ResponseEntity<List<Prof>> getMyProfs(@PathVariable Long studentId) {
        return new ResponseEntity<>(studentService.getMyProfs(studentId), HttpStatus.OK) ;
    }

}
