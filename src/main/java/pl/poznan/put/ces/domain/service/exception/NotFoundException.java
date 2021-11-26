package pl.poznan.put.ces.domain.service.exception;

/**
 * Not found exception
 */
public class NotFoundException extends RuntimeException {
    public NotFoundException(String message) {
        super(message + " not found!");
    }
}
