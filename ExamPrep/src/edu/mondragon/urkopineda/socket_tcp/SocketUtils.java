package edu.mondragon.urkopineda.socket_tcp;

import edu.mondragon.urkopineda.data.Message;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Socket utils for client and server sockets.
 *
 * @author urko
 */
public class SocketUtils {

    private Socket socket;
    private InputStream input;
    private OutputStream output;

    public SocketUtils(Socket socket) {
        this.socket = socket;
    }

    public void createIO() throws IOException {
        input = socket.getInputStream();
        output = socket.getOutputStream();
    }

    public Message read() {
        Message message = new Message();
        int max = 0, count;
        byte [] buffer = new byte[256];
        try {
            while ((count = input.read(buffer, max, 256 - max)) > 0) {
                max += count;
                if (buffer[max - 1] == (byte) message.FINAL_CHAR) {
                    byte [] data = new byte[max];
                    for (int i = 0; i < max; i++) data[i] = buffer[i];
                    message.parse(data);
                    return message;
                }
            }
        } catch (IOException e) {
            System.out.println("ERROR: " + e.getMessage());
        } return message;
    }

    public void write(Message message) {
        try {
            output.write(message.getBytes());
            output.flush();
        } catch (IOException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    public void close() throws IOException {
        input.close();
        output.close();
        socket.close();
    }

}
