package springmvc_ensa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import springmvc_ensa.entities.Course;
import springmvc_ensa.entities.Prof;

import java.util.List;

@Repository()
public interface ProfRepo extends JpaRepository<Prof, Long> {
    @Query("SELECT c FROM Prof c WHERE LOWER(c.username) LIKE %:query% OR LOWER(c.description) LIKE %:query% OR LOWER(c.email) LIKE %:query%")
    List<Prof> searchByNameOrDescription(@Param("query") String query);
}
