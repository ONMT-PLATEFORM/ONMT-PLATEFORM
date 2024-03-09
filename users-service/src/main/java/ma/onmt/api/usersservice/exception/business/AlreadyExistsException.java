package ma.onmt.api.usersservice.exception.business;

public class AlreadyExistsException extends RuntimeException{

    public AlreadyExistsException(String message){
        super(message);
    }


}
