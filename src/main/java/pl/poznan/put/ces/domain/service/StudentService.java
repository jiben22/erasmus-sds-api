package pl.poznan.put.ces.domain.service;

import pl.poznan.put.ces.domain.entity.Student;

public interface StudentService {
    Student addStudent(Student student);
    boolean isAuthenticated (String email, String password);
    Student findByEmail(String email);
}
