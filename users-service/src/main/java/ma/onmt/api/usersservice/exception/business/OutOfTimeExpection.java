package ma.onmt.api.usersservice.exception.business;

public class OutOfTimeExpection extends RuntimeException{

    public OutOfTimeExpection(String message) {
        super(message);
    }
}
