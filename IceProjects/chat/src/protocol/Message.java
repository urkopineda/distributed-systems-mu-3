package protocol;

import exception.IncorrectMessageFormatException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Message protocol between clients and server.
 *
 * @author urko
 */
public class Message {

    private String timeStamp;
    private String user;
    private String content;

    public Message(String message) throws IncorrectMessageFormatException {
        if (!parseMessage(message)) {
            throw new IncorrectMessageFormatException("ERROR: The message format is incorrect. " +
                                                      "Format must be <TIMESTAMP>%<USERNAME>%<CONTENT>.");
        }
    }

    private boolean parseMessage(String message) {
        Matcher matcher = Pattern.compile("^([0-2]+:[0-9]+:[0-9]+)%([a-z]+)%([a-zA-Z0-9 ]+)$").matcher(message);
        if (matcher.matches()) {
            this.timeStamp = matcher.group(1);
            this.user = matcher.group(2);
            this.content = matcher.group(3);
            return true;
        } else return false;
    }

    public String getTimeStamp(){
        return timeStamp;
    }

    public String getUser() {
        return user;
    }

    public String getContent() {
        return content;
    }

}
