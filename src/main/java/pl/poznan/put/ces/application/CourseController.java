package pl.poznan.put.ces.application;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.poznan.put.ces.application.response.CourseDto;
import pl.poznan.put.ces.application.response.CourseResponseDto;
import pl.poznan.put.ces.domain.entity.Course;
import pl.poznan.put.ces.domain.entity.enums.Diploma;
import pl.poznan.put.ces.domain.service.CourseService;

import java.util.List;
import java.util.Optional;

import static pl.poznan.put.ces.application.constants.Constants.CourseController.BASE_URL;
import static pl.poznan.put.ces.application.constants.Constants.CourseController.GET_COURSE_URL;

/**
 * Course controller
 */
@Slf4j
@RestController
@RequestMapping(BASE_URL)
public class CourseController {

    private final CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping(produces = "application/json")
    public List<CourseDto> getCourses(@PathVariable String facultyId,
                                   @RequestParam(required = false) Optional<Diploma> diploma) {
        return CourseResponseDto.toCoursesDto(courseService.getCourses(facultyId, diploma));
    }

    @GetMapping(value = GET_COURSE_URL,  produces = "application/json")
    public CourseDto getCourse(@PathVariable String facultyId, @PathVariable String id) {
        return CourseResponseDto.toCourseDto(courseService.getCourse(facultyId, id));
    }
}
