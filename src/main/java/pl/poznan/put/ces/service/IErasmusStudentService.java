package pl.poznan.put.ces.service;

import org.aspectj.weaver.Position;
import org.springframework.security.core.userdetails.UserDetailsService;
import pl.poznan.put.ces.domain.entity.ErasmusStudent;

import java.util.List;

public interface IErasmusStudentService extends UserDetailsService {
    boolean exists(long id);
    ErasmusStudent getErasmusStudent(long id);
    ErasmusStudent getErasmusStudentByEmail(String email);
    List<ErasmusStudent> getErasmusStudents();
    List<ErasmusStudent> searchErasmusStudents(Position position, String firstname, String lastname, String email);
    ErasmusStudent addErasmusStudent(ErasmusStudent student);
    ErasmusStudent editErasmusStudent(ErasmusStudent student);
    void deleteErasmusStudent(long id);
}