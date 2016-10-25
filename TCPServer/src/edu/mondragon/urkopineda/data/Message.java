package edu.mondragon.urkopineda.data;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Standardized class that contains the message to be sent between server and client.
 *
 * @author urko
 */
public class Message {

    public static final char FINAL_CHAR = '$';
    private String data;
    private String command;
    private long x;
    private long y;

    public Message(byte [] data) {
        parse(new String(data, 0, data.length));
    }

    public Message(byte [] data, Object o) {
        this.command = "echo";
        this.data = new String(data, 0, data.length);
    }

    public void parse(String data) {
        Matcher matcher = Pattern.compile("([a-z]*)['%']([0-9]*)['%']([0-9]*)['$']").matcher(data);
        if (matcher.matches()) {
            this.command = matcher.group(1);
            this.x = Integer.parseInt(matcher.group(2));
            this.y = Integer.parseInt(matcher.group(3));
        }
    }

    public byte[] getBytes() {
        return toString().getBytes();
    }

    public String getCommand() {
        return command;
    }

    public long getX() {
        return x;
    }

    public long getY() {
        return y;
    }

    public String getData() {
        return data;
    }

    @Override
    public String toString() {
        return command + "%" + x + "%" + y + FINAL_CHAR;
    }

}
