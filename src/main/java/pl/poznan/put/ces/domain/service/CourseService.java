package pl.poznan.put.ces.domain.service;

import pl.poznan.put.ces.domain.entity.Course;
import pl.poznan.put.ces.domain.entity.enums.Diploma;

import java.util.List;
import java.util.Optional;

/**
 * Course service interface
 */
public interface CourseService {

    List<Course> getCourses(String facultyId, Optional<Diploma> diploma);
    Course getCourse(String facultyId, String id);
    Boolean updateCourse(Course course);
}
