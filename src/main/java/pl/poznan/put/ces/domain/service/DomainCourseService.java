package pl.poznan.put.ces.domain.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.poznan.put.ces.domain.entity.Course;
import pl.poznan.put.ces.domain.service.exception.FacultyNotFoundException;
import pl.poznan.put.ces.infrastructure.CourseRepository;

import java.util.List;

/**
 * Course service
 */
@RequiredArgsConstructor
@Service
public class DomainCourseService implements CourseService {

    private final CourseRepository repository;

    @Override
    public List<Course> getCourses() {
        return repository.findAll();
    }

    @Override
    public Course getCourse(String title) {
        return repository.findByName(title).orElseThrow(() -> new FacultyNotFoundException(title));
    }
}
