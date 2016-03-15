package exception;

/**
 * Message format exception thrown when trying to parse a incompatible format message.
 *
 * @author urko
 */
public class IncorrectMessageFormatException extends Exception {

    public IncorrectMessageFormatException(String message) {
        super(message);
    }

}
