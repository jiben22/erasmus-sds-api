package pl.poznan.put.ces.infrastructure;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.poznan.put.ces.domain.entity.ErasmusStudent;

import java.util.List;
import java.util.Optional;

/**
 * ErasmusStudent repository
 */
@Repository
public interface ErasmusStudentRepository extends CrudRepository<ErasmusStudent, String> {

    Optional<ErasmusStudent> findByEmail(String email);
}
