package ma.onmt.api.usersservice.exception.business;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(Throwable cause) {
        super(cause);
    }

    public UserNotFoundException() {
    }

    public UserNotFoundException(String message) {
        super(message);
    }
}
