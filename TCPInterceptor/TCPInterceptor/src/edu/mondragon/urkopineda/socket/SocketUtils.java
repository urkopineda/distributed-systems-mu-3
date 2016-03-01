package edu.mondragon.urkopineda.socket;

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

    public String read() {
        byte [] buffer = new byte[256];
        try {
            input.read(buffer, 0, 256);
            return new String(buffer, 0, buffer.length);
        } catch (IOException e) {
            System.out.println("ERROR: " + e.getMessage());
        } return null;
    }

    public void write(String message) {
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
