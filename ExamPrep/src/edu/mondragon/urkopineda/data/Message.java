package edu.mondragon.urkopineda.data;

/**
 * Standardized class that contains the message to be sent between server and client.
 *
 * @author urko
 */
public class Message {

    public final char FINAL_CHAR = '$';
    private String data;

    public Message() {}

    public Message(String data) {
        this.data = data + FINAL_CHAR;
    }

    public Message(byte [] data) {
        parse(data);
    }

    public void parse(byte [] array) {
        this.data = new String(array, 0, array.length);
        this.data.replace(new String("") + FINAL_CHAR, "");
    }

    public byte[] getBytes() {
        return data.getBytes();
    }

    @Override
    public String toString() {
        return data;
    }

}
