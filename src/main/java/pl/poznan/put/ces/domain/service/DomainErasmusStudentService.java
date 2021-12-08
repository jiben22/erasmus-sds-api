package pl.poznan.put.ces.domain.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.poznan.put.ces.domain.entity.ErasmusStudent;
import pl.poznan.put.ces.domain.entity.Profile;
import pl.poznan.put.ces.infrastructure.ErasmusStudentRepository;

@RequiredArgsConstructor
@Service
public class DomainErasmusStudentService implements ErasmusStudentService {

    private final ErasmusStudentRepository repository;

    @Override
    public boolean isAuthenticated(String email, String password) {
        boolean isAuthenticated = false;

        ErasmusStudent erasmusStudent = repository.findByEmail(email);
        if (erasmusStudent != null) {
            isAuthenticated = Profile.encoder.matches(password, erasmusStudent.getPassword());
        }

        return isAuthenticated;
    }
}
