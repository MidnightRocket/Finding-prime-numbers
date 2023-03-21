package midnightrocket.java.exceptions;

public class NotEvenNumberException extends IllegalArgumentException{
    public NotEvenNumberException(String msg) {
        super(msg);
    }
    public NotEvenNumberException() {
        super("Must be an even number!");
    }
}