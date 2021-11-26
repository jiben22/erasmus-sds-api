package pl.poznan.put.ces.domain.service.exception;

/**
 * Faculty not found exception
 */
public class FacultyNotFoundException extends NotFoundException {
    public FacultyNotFoundException(String message) {
        super("Faculty "+ message);
    }
}
