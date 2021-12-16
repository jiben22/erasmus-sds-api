package pl.poznan.put.ces.application.response;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pl.poznan.put.ces.domain.entity.Course;
import pl.poznan.put.ces.domain.factory.CourseFactory;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.*;

public class CourseResponseDtoTest {

    @DisplayName("To Courses DTO")
    @Test
    public void toCoursesDto() {
        List<Course> courses = List.of(CourseFactory.getObjectProgrammingCourse(),
                CourseFactory.getCareerResourcesCourse());
        List<CourseDto> coursesDto = CourseResponseDto.toCoursesDto(courses);

        AtomicInteger index = new AtomicInteger();
        coursesDto.forEach(courseDto -> {
            Course course = courses.get(index.getAndIncrement());
            assertEquals(course.getId(), courseDto.getId());
            assertEquals(course.getTitle(), courseDto.getTitle());
            assertEquals(course.getDescription(), courseDto.getDescription());
            assertEquals(course.getEcts(), courseDto.getEcts());
            assertEquals(course.getHours(), courseDto.getHours());
            assertEquals(course.getSemester(), courseDto.getSemester());
            assertEquals(course.getDescriptionCardUrl(), courseDto.getDescriptionCardUrl());
            assertEquals(course.getDiploma(), courseDto.getDiploma());
        });
    }

    @DisplayName("To Course DTO")
    @Test
    public void toCourseDto() {
        Course course = CourseFactory.getObjectProgrammingCourse();
        CourseDto courseDto = CourseResponseDto.toCourseDto(course);

        assertEquals(course.getId(), courseDto.getId());
        assertEquals(course.getTitle(), courseDto.getTitle());
        assertEquals(course.getDescription(), courseDto.getDescription());
        assertEquals(course.getEcts(), courseDto.getEcts());
        assertEquals(course.getHours(), courseDto.getHours());
        assertEquals(course.getSemester(), courseDto.getSemester());
        assertEquals(course.getDescriptionCardUrl(), courseDto.getDescriptionCardUrl());
        assertEquals(course.getDiploma(), courseDto.getDiploma());
    }
}
