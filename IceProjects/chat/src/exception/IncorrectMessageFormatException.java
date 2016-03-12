package exception;

/**
 * Message format exception thrown when trying to parse a incompatible format message.
 *
 * @author urko
 */
public class IncorrectMessageFormatException extends Exception {

    public IncorrectMessageFormatException() {
        super();
    }

    public IncorrectMessageFormatException(String message) {
        super(message);
    }

    public IncorrectMessageFormatException(String message, Throwable cause) {
        super(message, cause);
    }

    public IncorrectMessageFormatException(Throwable cause) {
        super(cause);
    }

}
