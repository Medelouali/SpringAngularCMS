package springmvc_ensa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springmvc_ensa.entities.Mark;

@Repository()
public interface MarkRepo extends JpaRepository<Mark, Long> {
}
