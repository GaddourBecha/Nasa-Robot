package exception;

public class DirectionNotValidException extends RuntimeException {

    public DirectionNotValidException() {
        super("Direction is not valid");
    }
}
