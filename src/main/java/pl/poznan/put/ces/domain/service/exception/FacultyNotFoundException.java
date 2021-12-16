package pl.poznan.put.ces.domain.service.exception;

/**
 * Faculty not found exception
 */
public class FacultyNotFoundException extends NotFoundException {
    public FacultyNotFoundException(String id) {
        super(String.format("ID faculty: %s", id));
    }
}
