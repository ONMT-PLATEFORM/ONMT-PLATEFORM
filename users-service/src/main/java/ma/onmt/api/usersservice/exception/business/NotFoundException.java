package ma.onmt.api.usersservice.exception.business;

public class NotFoundException extends RuntimeException{
    public NotFoundException(Throwable cause) {
        super(cause);
    }

    public NotFoundException() {
    }

    public NotFoundException(String message) {
        super(message);
    }
}
