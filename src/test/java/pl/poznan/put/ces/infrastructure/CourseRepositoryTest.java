package pl.poznan.put.ces.infrastructure;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.apachecommons.ReflectionEquals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import pl.poznan.put.ces.domain.entity.Course;
import pl.poznan.put.ces.domain.entity.enums.Diploma;
import pl.poznan.put.ces.domain.factory.CourseFactory;
import pl.poznan.put.ces.domain.factory.FacultyFactory;

import java.util.List;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.samePropertyValuesAs;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
public class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;

    @DisplayName("Get all courses by faculty id")
    @Test
    public void findAllByFacultyId() {
        List<Course> courses = courseRepository.findAllByFacultyId(FacultyFactory.getComputingTelecommunicationsFaculty().getId());
        assertEquals(8, courses.size());
    }

//    @DisplayName("Get all courses by faculty id and diploma")
//    @Test
//    public void findAllByFacultyIdAndDiploma() {
//        List<Course> courses = courseRepository.findAllByFacultyIdAndDiploma(FacultyFactory.getComputingTelecommunicationsFaculty().getId(), Diploma.BSC);
//        assertEquals(3, courses.size());
//    }

    @DisplayName("Get course with a faculty id and course id")
    @Test
    public void findByFacultyIdAndId() {
        Optional<Course> optionalCourse = courseRepository.findByFacultyIdAndId(FacultyFactory.getComputingTelecommunicationsFaculty().getId(),
                CourseFactory.getObjectProgrammingCourse().getId());
        assertTrue(optionalCourse.isPresent());
        Course course = optionalCourse.get();
        assertThat(course, samePropertyValuesAs(CourseFactory.getObjectProgrammingCourse(), "faculty"));
    }
}