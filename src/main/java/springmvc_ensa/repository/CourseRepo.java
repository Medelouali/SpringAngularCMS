package springmvc_ensa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import springmvc_ensa.entities.Course;

import java.util.List;

@Repository()
public interface CourseRepo extends JpaRepository<Course, Long> {
    @Query("SELECT c FROM Course c WHERE LOWER(c.name) LIKE %:query% OR LOWER(c.description) LIKE %:query%")
    List<Course> searchByNameOrDescription(@Param("query") String query);
}
