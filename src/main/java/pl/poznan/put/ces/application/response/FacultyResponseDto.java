package pl.poznan.put.ces.application.response;

import pl.poznan.put.ces.domain.entity.Faculty;

import java.util.List;
import java.util.stream.Collectors;

public class FacultyResponseDto {

    public static List<FacultyDto> toFacultiesDto(List<Faculty> faculties) {
        return faculties.stream()
                .map(FacultyResponseDto::toFacultyDto)
                .collect(Collectors.toList());
    }

    public static FacultyDto toFacultyDto(Faculty faculty) {
        return FacultyDto.builder()
                .id(faculty.getId())
                .name(faculty.getName())
                .imageUrl(faculty.getImageUrl())
                .build();
    }
}
