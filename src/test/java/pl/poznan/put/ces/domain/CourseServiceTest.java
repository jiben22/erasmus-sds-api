package pl.poznan.put.ces.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.internal.matchers.apachecommons.ReflectionEquals;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import pl.poznan.put.ces.domain.entity.Course;
import pl.poznan.put.ces.domain.entity.enums.Diploma;
import pl.poznan.put.ces.domain.factory.CourseFactory;
import pl.poznan.put.ces.domain.factory.FacultyFactory;
import pl.poznan.put.ces.domain.service.DomainCourseService;
import pl.poznan.put.ces.domain.service.exception.CourseNotFoundException;
import pl.poznan.put.ces.domain.service.exception.FacultyNotFoundException;
import pl.poznan.put.ces.infrastructure.CourseRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

import static java.util.Optional.ofNullable;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.samePropertyValuesAs;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class CourseServiceTest {
    @Mock
    private CourseRepository courseRepository;

    @InjectMocks
    private DomainCourseService courseService;

    @DisplayName("Get all courses - without the filter diploma")
    @Test()
    public void getCourses() {
        List<Course> allCourses = Arrays.asList(CourseFactory.getObjectProgrammingCourse(),
                CourseFactory.getCareerResourcesCourse());

        when(courseRepository.findAllByFacultyId(anyString())).thenReturn(allCourses);

        List<Course> courses = courseService.getCourses(FacultyFactory.getComputingTelecommunicationsFaculty().getId(), Optional.empty());
        AtomicInteger index = new AtomicInteger();
        courses.forEach(course ->
                assertThat(course, samePropertyValuesAs(allCourses.get(index.getAndIncrement())))
        );
    }

    @DisplayName("Get all courses - with the filter diploma")
    @Test()
    public void getCoursesByDiploma() {
        List<Course> allCourses = Arrays.asList(CourseFactory.getObjectProgrammingCourse(),
                CourseFactory.getCareerResourcesCourse(), CourseFactory.getSoftwareDevelopmentStudio2Course());

        when(courseRepository.findAllByFacultyIdAndDiploma(anyString(), any(Diploma.class))).thenReturn(allCourses);

        List<Course> courses = courseService.getCourses(FacultyFactory.getComputingTelecommunicationsFaculty().getId(),
                Optional.empty());
        AtomicInteger index = new AtomicInteger();
        courses.forEach(course ->
                assertThat(course, samePropertyValuesAs(allCourses.get(index.getAndIncrement())))
        );
    }

    @DisplayName("Get course with an id")
    @Test
    public void getCourseById(){
        when(courseRepository.findByFacultyIdAndId(anyString(), anyString()))
                .thenReturn(ofNullable(CourseFactory.getCareerResourcesCourse()));

        Course course = courseService.getCourse(CourseFactory.getCareerResourcesCourse().getFaculty().getId(),
                CourseFactory.getCareerResourcesCourse().getId());
        assertThat(course, samePropertyValuesAs(CourseFactory.getCareerResourcesCourse(), "faculty"));
    }

    @DisplayName("Get course with an unknown id")
    @Test()
    public void getCourseUnknownIdException() {
        when(courseRepository.findByFacultyIdAndId(anyString(), anyString())).thenReturn(Optional.empty());
        assertThrows(CourseNotFoundException.class, () -> courseService.getCourse("FacultyXXX", "CourseXXX"));
    }
}

