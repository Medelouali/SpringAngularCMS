package springmvc_ensa.service;

import org.springframework.stereotype.Service;
import springmvc_ensa.entities.Admin;
import springmvc_ensa.entities.Prof;
import springmvc_ensa.entities.Student;
import springmvc_ensa.helpers.dtos.NewUserDto;
import springmvc_ensa.repository.AdminRepo;
import springmvc_ensa.repository.ProfRepo;
import springmvc_ensa.repository.StudentRepo;

@Service
public class UserService {
    private final AdminRepo adminRepo;
    private final StudentRepo studentRepo;
    private final ProfRepo profRepo;

    public UserService(AdminRepo adminRepo, StudentRepo studentRepo, ProfRepo profRepo) {
        this.adminRepo = adminRepo;
        this.studentRepo = studentRepo;
        this.profRepo = profRepo;
    }

    public Admin addAdmin(NewUserDto newUserDto){
        return this.adminRepo.save(
                new Admin(newUserDto.getUsername(), newUserDto.getEmail(), newUserDto.getDescription())
        );
    }

    public Student addStudent(NewUserDto newUserDto){
        return this.studentRepo.save(
                new Student(newUserDto.getUsername(), newUserDto.getEmail(), newUserDto.getDescription())
        );
    }

    public Prof addProf(NewUserDto newUserDto){
        return this.profRepo.save(
                new Prof(
                        newUserDto.getUsername(), newUserDto.getEmail(), newUserDto.getDescription()
                )
        );
    }
}
