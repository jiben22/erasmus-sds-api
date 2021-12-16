package pl.poznan.put.ces.domain.factory;

import pl.poznan.put.ces.domain.entity.Faculty;

/**
 * Factory about faculties
 */
public class FacultyFactory {

    public static Faculty getArchitectureFaculty() {
        return Faculty.builder()
                .id("architecture")
                .name("Architecture")
                .imageUrl("faculty-architecture.webp")
                .build();
    }

    public static Faculty getComputingTelecommunicationsFaculty() {
        return Faculty.builder()
                .id("computing-telecommunications")
                .name("Computing and Telecommunications")
                .imageUrl("faculty-computing-telecommunications.webp")
                .build();
    }
}
