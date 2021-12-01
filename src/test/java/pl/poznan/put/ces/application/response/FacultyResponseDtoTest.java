package pl.poznan.put.ces.application.response;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pl.poznan.put.ces.domain.entity.Faculty;
import pl.poznan.put.ces.domain.factory.FacultyFactory;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FacultyResponseDtoTest {

    @DisplayName("To Faculties DTO")
    @Test
    public void toFacultiesDto() {
        List<Faculty> faculties = List.of(FacultyFactory.getArchitectureFaculty(),
                FacultyFactory.getComputingTelecommunicationsFaculty());
        List<FacultyDto> facultiesDto = FacultyResponseDto.toFacultiesDto(faculties);

        AtomicInteger index = new AtomicInteger();
        facultiesDto.forEach(facultyDto -> {
            Faculty faculty = faculties.get(index.getAndIncrement());
            assertEquals(faculty.getId(), facultyDto.getId());
            assertEquals(faculty.getName(), facultyDto.getName());
            assertEquals(faculty.getImageUrl(), facultyDto.getImageUrl());
        });
    }

    @DisplayName("To Faculty DTO")
    @Test
    public void toFacultyDto() {
        Faculty faculty = FacultyFactory.getArchitectureFaculty();
        FacultyDto facultyDto = FacultyResponseDto.toFacultyDto(faculty);

        assertEquals(faculty.getId(), facultyDto.getId());
        assertEquals(faculty.getName(), facultyDto.getName());
        assertEquals(faculty.getImageUrl(), facultyDto.getImageUrl());
    }
}
