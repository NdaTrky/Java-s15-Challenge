package exceptions;

public class UserLimitExceededException  extends RuntimeException {

    public UserLimitExceededException(String message){
        super(message);
    }
}
