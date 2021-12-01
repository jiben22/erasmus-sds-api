package pl.poznan.put.ces;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import pl.poznan.put.ces.application.CourseController;
import pl.poznan.put.ces.application.FacultyController;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class CesApplicationTests {

    @Autowired
    private FacultyController facultyController;

    @Autowired
    private CourseController courseController;

	@Test
	void contextLoads() {
        assertThat(facultyController).isNotNull();
        assertThat(courseController).isNotNull();
	}

}
