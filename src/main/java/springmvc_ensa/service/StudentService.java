package springmvc_ensa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springmvc_ensa.entities.Course;
import springmvc_ensa.entities.Prof;
import springmvc_ensa.entities.Student;
import springmvc_ensa.repository.StudentRepo;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepo studentRepo;

    @Autowired
    public StudentService(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }


    public List<Student> getStudents() {
        return this.studentRepo.findAll();
    }

    public Student deleteStudent(long id) {
        Optional<Student> optionalAdmin = studentRepo.findById(id);
        if (optionalAdmin.isPresent()) {
            Student admin = optionalAdmin.get();
            studentRepo.deleteById(id);
            return admin;
        }
        return null;
    }

    public List<Course> getMyCourses(Long studentId) {
        Optional<Student> optionalStudent = studentRepo.findById(studentId);
        if (optionalStudent.isPresent()) {
            Student student = optionalStudent.get();
            return student.getCourses();
        } else {
            // Handle case when the student is not found
            throw new IllegalArgumentException("Student not found");
        }
    }

    public List<Prof> getMyProfs(Long studentId) {
        Student student = studentRepo.findById(studentId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid student ID"));

        return student.getProfs();
    }
}
