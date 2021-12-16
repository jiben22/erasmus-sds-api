package pl.poznan.put.ces.domain.service.exception;

/**
 * ErasmusStudent not found exception
 */
public class ErasmusStudentNotFoundException extends NotFoundException {
    public ErasmusStudentNotFoundException(String message) {
        super("ErasmusStudent "+ message);
    }
}
