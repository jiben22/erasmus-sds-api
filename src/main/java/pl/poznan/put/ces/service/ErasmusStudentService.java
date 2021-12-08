package pl.poznan.put.ces.service;

import lombok.RequiredArgsConstructor;
import org.aspectj.weaver.Position;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.poznan.put.ces.domain.entity.ErasmusStudent;
import pl.poznan.put.ces.infrastructure.ErasmusStudentRepository;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ErasmusStudentService implements IErasmusStudentService {

    private final ErasmusStudentRepository repository;

    @Override
    public boolean exists(long id) {
        return false;
    }

    @Override
    public ErasmusStudent getErasmusStudent(long id) {
        return null;
    }

    @Override
    public static ErasmusStudent getErasmusStudentByEmail(String email) {
        return null;
    }

    @Override
    public List<ErasmusStudent> getErasmusStudents() {
        return null;
    }

    @Override
    public List<ErasmusStudent> searchErasmusStudents(Position position, String firstname, String lastname, String email) {
        return null;
    }

    @Override
    public ErasmusStudent addErasmusStudent(ErasmusStudent student) {
        return null;
    }

    @Override
    public ErasmusStudent editErasmusStudent(ErasmusStudent student) {
        return null;
    }

    @Override
    public void deleteErasmusStudent(long id) {

    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return null;
    }
}
