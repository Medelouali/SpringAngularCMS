package springmvc_ensa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springmvc_ensa.entities.Admin;
import springmvc_ensa.entities.Prof;
import springmvc_ensa.entities.Student;
import springmvc_ensa.helpers.dtos.NewUserDto;
import springmvc_ensa.service.AdminService;
import springmvc_ensa.service.UserService;

import java.util.List;

@RestController
@RequestMapping("api/admins")
public class AdminController {
    private final AdminService adminService;
    private final UserService userService;

    @Autowired
    public AdminController(AdminService adminService, UserService userService) {
        this.adminService = adminService;
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<Admin>> getAdmins() {
        return new ResponseEntity<>(adminService.getAdmins(), HttpStatus.OK) ;
    }

    @PostMapping
    public ResponseEntity<Admin> addAdmin(@RequestBody NewUserDto newUserDto){
        System.out.println("Got here");
        return new ResponseEntity<>(this.userService.addAdmin(newUserDto), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Admin> deleteAdmin(@PathVariable long id){
        return new ResponseEntity<>(this.adminService.deleteAdmin(id), HttpStatus.OK);
    }

}
