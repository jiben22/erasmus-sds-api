package pl.poznan.put.ces.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.poznan.put.ces.domain.entity.Course;
import pl.poznan.put.ces.domain.service.CourseService;

import java.util.List;

import static pl.poznan.put.ces.application.constants.Constants.CourseController.BASE_URL;
import static pl.poznan.put.ces.application.constants.Constants.CourseController.GET_COURSE_URL;

/**
 * Course controller
 */
@RestController
@RequestMapping(BASE_URL)
public class CourseController {

    private final CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping(produces = "application/json")
    public List<Course> getCourses() {
        return courseService.getCourses();
    }

    @GetMapping(value = GET_COURSE_URL,  produces = "application/json")
    public Course getCourse(@PathVariable String title) {
        return courseService.getCourse(title);
    }
}
