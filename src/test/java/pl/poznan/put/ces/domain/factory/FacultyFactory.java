package pl.poznan.put.ces.domain.factory;

import pl.poznan.put.ces.domain.entity.Faculty;

/**
 * Factory about faculties
 */
public class FacultyFactory {

    public static Faculty getFaculty1(){
        return Faculty.builder()
                .name("Architecture")
                .imageUrl("faculty-architecture.webp")
                .build();
    }

    public static Faculty getFaculty2(){
        return Faculty.builder()
                .name("Automatic Control, Robotics & Electrical Engineering")
                .imageUrl("faculty-automatic-control-robotics-electrical-engineering.webp")
                .build();
    }
}
