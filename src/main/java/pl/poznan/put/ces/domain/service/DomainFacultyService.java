package pl.poznan.put.ces.domain.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.poznan.put.ces.domain.entity.Faculty;
import pl.poznan.put.ces.domain.service.exception.FacultyNotFoundException;
import pl.poznan.put.ces.infrastructure.FacultyRepository;

import java.util.List;

/**
 * Faculty service
 */
@RequiredArgsConstructor
@Service
public class DomainFacultyService implements FacultyService {

    private final FacultyRepository repository;

    @Override
    public List<Faculty> getFaculties() {
        return repository.findAll();
    }

    @Override
    public Faculty getFaculty(String id) {
        return repository.findById(id).orElseThrow(() -> new FacultyNotFoundException(id));
    }
}
