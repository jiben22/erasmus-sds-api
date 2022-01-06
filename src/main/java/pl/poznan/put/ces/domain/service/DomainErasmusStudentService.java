package pl.poznan.put.ces.domain.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.poznan.put.ces.domain.entity.ErasmusStudent;
import pl.poznan.put.ces.domain.entity.Profile;
import pl.poznan.put.ces.domain.service.exception.ErasmusStudentNotFoundException;
import pl.poznan.put.ces.infrastructure.ErasmusStudentRepository;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class DomainErasmusStudentService implements ErasmusStudentService {

    private final ErasmusStudentRepository repository;

    @Override
    public boolean isAuthenticated(String email, String password) {
        boolean isAuthenticated = false;

        Optional<ErasmusStudent> erasmusStudent = repository.findByEmail(email);
        if (erasmusStudent.isPresent()) {
            isAuthenticated = Profile.encoder.matches(password, erasmusStudent.get().getPassword());
        }

        return isAuthenticated;
    }

    @Override
    public ErasmusStudent findByEmail(String email) {
        return repository.findByEmail(email).orElseThrow(() -> new ErasmusStudentNotFoundException(email));
    }
}
