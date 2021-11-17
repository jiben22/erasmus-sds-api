package pl.poznan.put.ces.infrastructure;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.poznan.put.ces.domain.entity.Course;

import java.util.List;
import java.util.Optional;

/**
 * Course repository
 */
@Repository
public interface CourseRepository extends CrudRepository<Course, String> {

    List<Course> findAll();
    Optional<Course> findByTitle(String title);
}
