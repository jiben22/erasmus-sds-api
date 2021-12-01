package pl.poznan.put.ces.application.response;

import pl.poznan.put.ces.domain.entity.Course;
import pl.poznan.put.ces.domain.entity.Faculty;

import java.util.List;
import java.util.stream.Collectors;

public class CourseResponseDto {

    public static List<CourseDto> toCoursesDto(List<Course> courses) {
        return courses.stream()
                .map(CourseResponseDto::toCourseDto)
                .collect(Collectors.toList());
    }

    public static CourseDto toCourseDto(Course course) {
        return CourseDto.builder()
                .id(course.getId())
                .title(course.getTitle())
                .description(course.getDescription())
                .ects(course.getEcts())
                .hours(course.getHours())
                .semester(course.getSemester())
                .descriptionCardUrl(course.getDescriptionCardUrl())
                .diploma(course.getDiploma())
                .build();
    }
}
