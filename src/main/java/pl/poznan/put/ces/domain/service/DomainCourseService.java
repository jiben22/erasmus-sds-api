package pl.poznan.put.ces.domain.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.poznan.put.ces.domain.entity.Course;
import pl.poznan.put.ces.domain.entity.enums.Diploma;
import pl.poznan.put.ces.domain.service.exception.FacultyNotFoundException;
import pl.poznan.put.ces.infrastructure.CourseRepository;

import java.util.List;
import java.util.Optional;

/**
 * Course service
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class DomainCourseService implements CourseService {

    private final CourseRepository repository;

    @Override
    public List<Course> getCourses(String facultyId, Optional<Diploma> diploma) {
        List<Course> courses;
        if (diploma.isEmpty()) {
            courses = repository.findAllByFacultyId(facultyId);
        } else {
            log.info(String.valueOf(diploma.get()));
            courses = repository.findAllByFacultyIdAndDiploma(facultyId, diploma.get());
        }
        return courses;
    }

    @Override
    public Course getCourse(String facultyId, String id) {
        return repository.findByFacultyIdAndId(facultyId, id).orElseThrow(() -> new FacultyNotFoundException(id));
    }
}
