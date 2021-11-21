package pl.poznan.put.ces.domain.service;

import pl.poznan.put.ces.domain.entity.Faculty;

import java.util.List;

/**
 * Faculty service interface
 */
public interface FacultyService {

    List<Faculty> getFaculties();
    Faculty getFaculty(String id);
}
