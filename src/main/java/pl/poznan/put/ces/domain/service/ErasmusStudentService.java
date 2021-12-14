package pl.poznan.put.ces.domain.service;

import pl.poznan.put.ces.domain.entity.ErasmusStudent;

public interface ErasmusStudentService {

    boolean isAuthenticated(String email, String password);
    ErasmusStudent findByEmail(String email);
}