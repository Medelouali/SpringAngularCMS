package springmvc_ensa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import springmvc_ensa.entities.Course;
import springmvc_ensa.entities.Student;

import java.util.List;

@Repository()
public interface StudentRepo extends JpaRepository<Student, Long> {
    @Query("SELECT c FROM Student c WHERE LOWER(c.username) LIKE %:query% OR LOWER(c.description) LIKE %:query% OR LOWER(c.email) LIKE %:query%")
    List<Student> searchByNameOrDescription(@Param("query") String query);
}
