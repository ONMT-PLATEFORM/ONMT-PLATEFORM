package ma.onmt.api.regionservice.exception.business;

public class OutOfTimeExpection extends RuntimeException{

    public OutOfTimeExpection(String message) {
        super(message);
    }
}
