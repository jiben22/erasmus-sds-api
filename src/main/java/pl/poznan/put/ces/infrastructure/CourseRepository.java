package pl.poznan.put.ces.infrastructure;

import lombok.NonNull;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.poznan.put.ces.domain.entity.Course;
import pl.poznan.put.ces.domain.entity.enums.Diploma;

import java.util.List;
import java.util.Optional;

/**
 * Course repository
 */
@Repository
public interface CourseRepository extends CrudRepository<Course, String> {

    List<Course> findAllByFacultyId(@NonNull String facultyId);
    List<Course> findAllByFacultyIdAndDiploma(@NonNull String facultyId, Diploma diploma);
    Optional<Course> findByFacultyIdAndId(@NonNull String facultyId, String id);
}
