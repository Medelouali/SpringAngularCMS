package springmvc_ensa.service;

import javassist.NotFoundException;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springmvc_ensa.entities.Course;
import springmvc_ensa.entities.Prof;
import springmvc_ensa.entities.Student;
import springmvc_ensa.helpers.dtos.NewCourse;
import springmvc_ensa.repository.CourseRepo;
import springmvc_ensa.repository.ProfRepo;
import springmvc_ensa.repository.StudentRepo;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {
    private final CourseRepo courseRepo;
    private final StudentRepo studentRepo;
    private final ProfRepo profRepo;

    @Autowired
    public CourseService(CourseRepo courseRepo, StudentRepo studentRepo, ProfRepo profRepo) {
        this.courseRepo = courseRepo;
        this.studentRepo = studentRepo;
        this.profRepo = profRepo;
    }

    public List<Course> getCourses() {
        List<Course> courses = courseRepo.findAll();
        for (Course course : courses) {
            Hibernate.initialize(course.getStudents());
        }
        return courses;
    }

    public Course addCourse(NewCourse newCourse) {
        return this.courseRepo.save(new Course(newCourse.getName(), newCourse.getDescription()));
    }

    public Course joinCourse(Long studentId, Long courseId) {
        Optional<Student> optionalStudent = studentRepo.findById(studentId);
        Optional<Course> optionalCourse = courseRepo.findById(courseId);

        if (optionalStudent.isPresent() && optionalCourse.isPresent()) {
            Student student = optionalStudent.get();
            Course course = optionalCourse.get();

            student.getCourses().add(course);
            course.getStudents().add(student);

            studentRepo.save(student);
            courseRepo.save(course);
        } else {
            // Handle case when the student or course is not found
            throw new IllegalArgumentException("Student or course not found");
        }
        return null;
    }

    public Course assignProfToCourse(Long profId, Long courseId) {
        // Retrieve the professor and course entities from the database
        Optional<Prof> prof = profRepo.findById(profId);
        Optional<Course> course = courseRepo.findById(courseId);

        if(!prof.isPresent() || !course.isPresent()){
            new NotFoundException("Professor or course not found");
            return null;
        }
        // Set the professor for the course
        Course courseX=course.get();
        courseX.setProf(prof.get());

        // Update the course entity in the database
        return  courseRepo.save(courseX);
    }

    public Course deleteCourse(long id) {
        Optional<Course> optionalAdmin = courseRepo.findById(id);
        if (optionalAdmin.isPresent()) {
            Course admin = optionalAdmin.get();
            studentRepo.deleteById(id);
            return admin;
        }
        return null;
    }
}
