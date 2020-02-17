package exception;

public class CommandNotValidException extends RuntimeException {
    public CommandNotValidException() {
        super("Command not valid");
    }
}
