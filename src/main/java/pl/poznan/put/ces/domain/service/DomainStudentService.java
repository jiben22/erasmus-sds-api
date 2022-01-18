package pl.poznan.put.ces.domain.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pl.poznan.put.ces.domain.entity.Profile;
import pl.poznan.put.ces.domain.entity.Student;
import pl.poznan.put.ces.domain.service.exception.StudentNotFoundException;
import pl.poznan.put.ces.infrastructure.StudentRepository;

import java.util.Optional;

/**
 * Testimonial service
 */
@Slf4j
@RequiredArgsConstructor
@Service
public class DomainStudentService implements StudentService {

    private final StudentRepository repository;

    @Override
    public boolean isAuthenticated(String email, String password) {
        boolean isAuthenticated = false;

        Optional<Student> student = repository.findByEmail(email);
        if (student.isPresent()) {
            isAuthenticated = Profile.encoder.matches(password, student.get().getPassword());
        }

        return isAuthenticated;
    }

    @Override
    public Student findByEmail(String email) {
        return repository.findByEmail(email).orElseThrow(() -> new StudentNotFoundException(email));
    }

    @Override
    public Student addStudent(Student student) {
        return repository.saveAndFlush(student);
    }
}
