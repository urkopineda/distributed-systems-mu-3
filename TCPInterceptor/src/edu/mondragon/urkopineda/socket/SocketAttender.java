package edu.mondragon.urkopineda.socket;

import edu.mondragon.urkopineda.data.Buzon;

import java.io.IOException;
import java.net.Socket;

/**
 * Thread that attends a client received from the SocketServer class.
 *
 * @author urko
 */
public class SocketAttender extends Thread {

    private SocketUtils socket;
    private Buzon<String> b1;
    private Buzon<String> b2;
    private boolean exit;

    public SocketAttender(Socket socket, Buzon<String> b1, Buzon<String> b2) {
        this.socket = new SocketUtils(socket);
        this.b1 = b1;
        this.b2 = b2;
    }

    @Override
    public void run() {
        try {
            String message;
            socket.createIO();
            while (!exit) {
                message = socket.read();
                System.out.println("INTERCEPTOR SERVER: Client sends to server: " + message);
                b2.send(message);
                message = b1.receive();
                System.out.println("INTERCEPTOR SERVER: Server sends to client: " + message);
                socket.write(message);
            }
        } catch (IOException e) {
            System.out.println("ERROR: " + e.getMessage());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void close() throws IOException {
        exit = true;
        socket.close();
    }

}
