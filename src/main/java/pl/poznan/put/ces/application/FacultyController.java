package pl.poznan.put.ces.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.poznan.put.ces.domain.entity.Faculty;
import pl.poznan.put.ces.domain.service.FacultyService;

import java.util.List;

import static pl.poznan.put.ces.application.constants.Constants.FacultyController.BASE_URL;
import static pl.poznan.put.ces.application.constants.Constants.FacultyController.GET_FACULTY_URL;

/**
 * Faculty controller
 */
@RestController
@RequestMapping(BASE_URL)
public class FacultyController {

    private final FacultyService facultyService;

    @Autowired
    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @GetMapping(produces = "application/json")
    public List<Faculty> getFaculties() {
        return facultyService.getFaculties();
    }

    @GetMapping(value = GET_FACULTY_URL,  produces = "application/json")
    public Faculty getFaculty(@PathVariable String name) {
        return facultyService.getFaculty(name);
    }
}
