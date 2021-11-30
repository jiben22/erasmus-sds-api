package pl.poznan.put.ces.domain.factory;

import pl.poznan.put.ces.domain.entity.Course;
import pl.poznan.put.ces.domain.entity.enums.Diploma;
import pl.poznan.put.ces.domain.entity.enums.Semester;

/**
 * Factory about courses
 */
public class CourseFactory {

    public static Course getObjectProgrammingCourse() {
        return Course.builder()
                .id("object-programming")
                .title("Object Programming")
                .description("The goal of the course is to teach students how to model and create reusable, easily-maintainable software, by using tools provided by object-oriented programming languages. Moreover, the students will learn how to create and use custom data types, how to model software systems based on clean code principles, and how to communicate their work to other programmers.")
                .ects(4)
                .hours(60)
                .semester(Semester.WINTER)
                .descriptionCardUrl("Object-programming.pdf")
                .diploma(Diploma.BSC)
                .faculty(FacultyFactory.getComputingTelecommunicationsFaculty())
                .build();
    }

    public static Course getCareerResourcesCourse() {
        return Course.builder()
                .id("career-resources")
                .title("Career Resources")
                .description("Provide students with basic knowledge regarding interpersonal communication in the workplace. Provide students with contemporary problems of interpersonal communication. Develop students' skills in solving problems and communicating in groups. Advancing students' language competence towards the level at least B2 (CEFR).")
                .ects(2)
                .hours(30)
                .semester(Semester.WINTER)
                .descriptionCardUrl("Career-resources.pdf")
                .diploma(Diploma.BSC)
                .faculty(FacultyFactory.getComputingTelecommunicationsFaculty())
                .build();
    }

    public static Course getSoftwareDevelopmentStudio2Course() {
        return Course.builder()
                .id("quality-management-experimental-software-engineering")
                .title("Quality Management and Experimental Software Engineering")
                .description("Provide students the knowledge regarding experimental Software Engineering, especially related to empirical research methods and their theoretical foundations.")
                .ects(5)
                .hours(60)
                .semester(Semester.WINTER)
                .descriptionCardUrl("Quality-management-and-experimental-software-engineering.pdf")
                .diploma(Diploma.MASTER)
                .faculty(FacultyFactory.getComputingTelecommunicationsFaculty())
                .build();
    }
}
