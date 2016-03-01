package edu.mondragon.urkopineda.data;

/**
 * Standardized class that contains the message to be sent between server and client.
 *
 * @author urko
 */
public class Message {

    public static final char FINAL_CHAR = '$';
    private String command;
    private long x;
    private long y;

    public Message() {}

    public Message(String data) {
        parse(data);
    }

    public Message(byte [] data) {
        parse(new String(data, 0, data.length));
    }

    public Message(String command, long x, long y) {
        this.command = command;
        this.x = x;
        this.y = y;
    }

    public void parse(String data) {
        String [] values = data.split("^([a-z]*)[  ]([0-9]*)[ ]([0-9]*)['$']$");
        this.command = values[0];
        this.x = Integer.parseInt(values[1]);
        this.y = Integer.parseInt(values[2]);
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

    @Override
    public String toString() {
        return command + "%" + x + "%" + y + FINAL_CHAR;
    }

}
