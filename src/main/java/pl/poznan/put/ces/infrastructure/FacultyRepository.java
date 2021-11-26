package pl.poznan.put.ces.infrastructure;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.poznan.put.ces.domain.entity.Faculty;

import java.util.List;
import java.util.Optional;

/**
 * Faculty repository
 */
@Repository
public interface FacultyRepository extends CrudRepository<Faculty, String> {

    List<Faculty> findAll();
    Optional<Faculty> findById(String id);
}
