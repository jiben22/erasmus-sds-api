package pl.poznan.put.ces.domain.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.poznan.put.ces.domain.entity.Profile;
import pl.poznan.put.ces.domain.entity.Student;
import pl.poznan.put.ces.infrastructure.StudentRepository;

/**
 * Testimonial service
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class DomainStudentService implements StudentService {

    private final StudentRepository repository;

    @Override
    public Student addStudent(Student student) {

        return repository.saveAndFlush(student);
    }
}
