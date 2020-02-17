package exception;

public class PositionNotValidException extends RuntimeException {
    public PositionNotValidException() {
        super("Position cannot be outside the plateau");
    }
}
