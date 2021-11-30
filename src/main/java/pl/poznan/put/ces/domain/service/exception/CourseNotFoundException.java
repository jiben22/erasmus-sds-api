package pl.poznan.put.ces.domain.service.exception;

/**
 * Course not found exception
 */
public class CourseNotFoundException extends NotFoundException {
    public CourseNotFoundException(String facultyId, String id) {
        super(String.format("ID faculty: %s - ID course: %s", facultyId, id));
    }
}
