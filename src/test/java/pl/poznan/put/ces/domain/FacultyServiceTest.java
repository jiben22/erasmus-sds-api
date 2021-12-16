package pl.poznan.put.ces.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.poznan.put.ces.domain.entity.Faculty;
import pl.poznan.put.ces.domain.factory.FacultyFactory;
import pl.poznan.put.ces.domain.service.DomainFacultyService;
import pl.poznan.put.ces.domain.service.exception.FacultyNotFoundException;
import pl.poznan.put.ces.infrastructure.FacultyRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

import static java.util.Optional.ofNullable;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.samePropertyValuesAs;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class FacultyServiceTest {
    @Mock
    private FacultyRepository facultyRepository;

    @InjectMocks
    private DomainFacultyService facultyService;

    @DisplayName("Get all faculties")
    @Test()
    public void getFaculties() {
        List<Faculty> allFaculties = Arrays.asList(FacultyFactory.getArchitectureFaculty(),
                FacultyFactory.getComputingTelecommunicationsFaculty());

        when(facultyRepository.findAll()).thenReturn(allFaculties);

        List<Faculty> faculties = facultyService.getFaculties();
        AtomicInteger index = new AtomicInteger();
        faculties.forEach(faculty ->
                assertThat(faculty, samePropertyValuesAs(allFaculties.get(index.getAndIncrement())))
        );
    }

    @DisplayName("Get faculty with an id")
    @Test
    public void getFaculty() {
        when(facultyRepository.findById(anyString()))
                .thenReturn(ofNullable(FacultyFactory.getArchitectureFaculty()));

        Faculty faculty = facultyService.getFaculty(FacultyFactory.getArchitectureFaculty().getName());
        assertThat(faculty, samePropertyValuesAs(FacultyFactory.getArchitectureFaculty()));
    }

    @DisplayName("Get faculty with an unknown id")
    @Test()
    public void getFacultyUnknownIdException() {
        when(facultyRepository.findById(anyString())).thenReturn(Optional.empty());
        assertThrows(FacultyNotFoundException.class, () -> facultyService.getFaculty("XXX"));
    }
}

