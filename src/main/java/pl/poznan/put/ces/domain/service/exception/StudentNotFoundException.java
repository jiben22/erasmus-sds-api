package pl.poznan.put.ces.domain.service.exception;

public class StudentNotFoundException extends NotFoundException {
    public StudentNotFoundException(String message) {
        super("Student "+ message);
    }
}
