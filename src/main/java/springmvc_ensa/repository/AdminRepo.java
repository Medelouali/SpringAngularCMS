package springmvc_ensa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import springmvc_ensa.entities.Admin;
import springmvc_ensa.entities.Course;

import java.util.List;

@Repository()
public interface AdminRepo extends JpaRepository<Admin, Long> {
    @Query("SELECT c FROM Admin c WHERE LOWER(c.username) LIKE %:query% OR LOWER(c.description) LIKE %:query% OR LOWER(c.email) LIKE %:query%")
    List<Admin> searchByNameOrDescription(@Param("query") String query);
}
