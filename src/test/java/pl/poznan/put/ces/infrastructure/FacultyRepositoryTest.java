package pl.poznan.put.ces.infrastructure;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.apachecommons.ReflectionEquals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import pl.poznan.put.ces.domain.entity.Faculty;
import pl.poznan.put.ces.domain.factory.CourseFactory;
import pl.poznan.put.ces.domain.factory.FacultyFactory;

import java.util.List;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.samePropertyValuesAs;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
public class FacultyRepositoryTest {

    @Autowired
    private FacultyRepository facultyRepository;

    @DisplayName("Get all faculties")
    @Test
    public void findAll() {
        List<Faculty> faculties = facultyRepository.findAll();
        assertEquals(9, faculties.size());
    }

    @DisplayName("Get faculty by id")
    @Test
    public void findById() {
        Optional<Faculty> optionalFaculty = facultyRepository.findById(FacultyFactory.getComputingTelecommunicationsFaculty().getId());
        assertTrue(optionalFaculty.isPresent());
        Faculty faculty = optionalFaculty.get();
        assertThat(faculty, samePropertyValuesAs(FacultyFactory.getComputingTelecommunicationsFaculty(), "courses"));
    }
}