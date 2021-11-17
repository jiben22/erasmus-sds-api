package pl.poznan.put.ces.domain.service;

import pl.poznan.put.ces.domain.entity.Course;

import java.util.List;

/**
 * Course service interface
 */
public interface CourseService {

    List<Course> getCourses();
    Course getCourse(String title);
}
