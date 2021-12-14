package pl.poznan.put.ces.application.exception;

/**
 * User not found exception
 */
public class UserNotFoundException extends Exception {

    public UserNotFoundException(String msg) {
        super(msg);
    }
}
