package pl.poznan.put.ces.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.poznan.put.ces.domain.entity.Student;


/**
 * Student repository
 */
@Repository
public interface StudentRepository extends JpaRepository<Student, String> {

}
