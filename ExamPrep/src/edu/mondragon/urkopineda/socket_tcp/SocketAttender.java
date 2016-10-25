package edu.mondragon.urkopineda.socket_tcp;

import edu.mondragon.urkopineda.data.Message;

import java.io.IOException;
import java.net.Socket;

/**
 * Thread that attends a client received from the SocketServer class.
 *
 * @author urko
 */
public class SocketAttender extends Thread {

    private SocketUtils socket;

    public SocketAttender(Socket socket) {
        this.socket = new SocketUtils(socket);
    }

    @Override
    public void run() {
        try {
            socket.createIO();
            //
            socket.write(new Message("Hola"));
            Message message = socket.read();
            System.out.println(message.toString());
            //
            socket.close();
        } catch (IOException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    public void close() throws IOException {
        socket.close();
    }

}
