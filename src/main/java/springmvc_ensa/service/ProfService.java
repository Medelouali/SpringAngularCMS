package springmvc_ensa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springmvc_ensa.entities.Admin;
import springmvc_ensa.entities.Prof;
import springmvc_ensa.entities.Student;
import springmvc_ensa.repository.ProfRepo;
import springmvc_ensa.repository.StudentRepo;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class ProfService {
    private final ProfRepo profRepo;
    private final StudentRepo studentRepo;

    @Autowired
    public ProfService(ProfRepo profRepo, StudentRepo studentRepo) {
        this.profRepo = profRepo;
        this.studentRepo = studentRepo;
    }

    public List<Prof> getProfs() {
        return this.profRepo.findAll();
    }

    public Prof deleteProf(long id) {
        Optional<Prof> optionalAdmin = profRepo.findById(id);
        if (optionalAdmin.isPresent()) {
            Prof admin = optionalAdmin.get();
            profRepo.deleteById(id);
            return admin;
        }
        return null;
    }

    public List<Student> getMyStudents(Long profId) {
        Prof professor = profRepo.findById(profId)
                .orElseThrow(
                        () -> new EntityNotFoundException("Professor not found with id: " + profId));

        return professor.getStudents();
    }

    public Prof assignProfToStudent(Long profId, Long studentId) {
        Student student = studentRepo.findById(studentId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid student ID"));

        Prof professor = profRepo.findById(profId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid professor ID"));

        List<Prof> profs=student.getProfs();
        profs.add(professor);
        student.setProfs(profs);
        studentRepo.save(student);
        return professor;
    }
}
