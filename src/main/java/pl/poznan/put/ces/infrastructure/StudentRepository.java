package pl.poznan.put.ces.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.poznan.put.ces.domain.entity.Profile;
import pl.poznan.put.ces.domain.entity.Student;

import java.util.Optional;


/**
 * Student repository
 */
@Repository
public interface StudentRepository extends JpaRepository<Profile, String> {

    Optional<Student> findByEmail(String email);
}
