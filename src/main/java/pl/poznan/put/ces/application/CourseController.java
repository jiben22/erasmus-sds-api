package pl.poznan.put.ces.application;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pl.poznan.put.ces.application.response.CourseDto;
import pl.poznan.put.ces.application.response.CourseResponseDto;
import pl.poznan.put.ces.domain.entity.Course;
import pl.poznan.put.ces.domain.entity.ErasmusStudent;
import pl.poznan.put.ces.domain.entity.Testimonial;
import pl.poznan.put.ces.domain.entity.enums.Diploma;
import pl.poznan.put.ces.domain.service.CourseService;
import pl.poznan.put.ces.domain.service.ErasmusStudentService;
import pl.poznan.put.ces.domain.service.TestimonialService;

import java.util.List;
import java.util.Optional;

import static pl.poznan.put.ces.application.constants.Constants.CourseController.*;

/**
 * Course controller
 */
@Slf4j
@RestController
@RequestMapping(BASE_URL)
public class CourseController {

    private final ErasmusStudentService erasmusStudentService;
    private final CourseService courseService;
    private final TestimonialService testimonialService;

    @Autowired
    public CourseController(ErasmusStudentService erasmusStudentService,
                            CourseService courseService,
                            TestimonialService testimonialService) {
        this.erasmusStudentService = erasmusStudentService;
        this.courseService = courseService;
        this.testimonialService = testimonialService;
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

    /**
     * Get course and add it the new testimonial created
     * @param facultyId ID Faculty
     * @param id ID course
     * @param testimonial Testimonial
     * @return ?
     */
    @PostMapping(value = POST_TESTIMONIAL_URL, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Boolean postTestimonial(@PathVariable String facultyId,
                                   @PathVariable String id,
                                   @RequestBody Testimonial testimonial) {
        ErasmusStudent erasmusStudent = erasmusStudentService.findByEmail(testimonial.getErasmusStudent().getEmail());
        testimonial.setErasmusStudent(erasmusStudent);

        Course course = courseService.getCourse(facultyId, id);
        testimonial.setCourse(course);

        testimonial = testimonialService.addTestimonial(testimonial);
        course.getTestimonials().add(testimonial);

        return courseService.updateCourse(course);
    }
}
