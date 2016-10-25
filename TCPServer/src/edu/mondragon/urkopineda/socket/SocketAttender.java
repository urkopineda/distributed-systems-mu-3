package edu.mondragon.urkopineda.socket;

import edu.mondragon.urkopineda.data.Message;
import edu.mondragon.urkopineda.math.Calculator;

import java.io.IOException;
import java.net.Socket;

/**
 * Thread that attends a client received from the SocketServer class.
 *
 * @author urko
 */
public class SocketAttender extends Thread {

    private SocketUtils socket;
    private boolean exit;

    public SocketAttender(Socket socket) {
        this.socket = new SocketUtils(socket);
    }

    @Override
    public void run() {
        try {
            socket.createIO();
            while (!exit) {
                Message message = socket.read();
                if (message != null) {
                    switch (message.getCommand()) {
                        case "gcd":
                            socket.write(String.valueOf(Calculator.gcd(message.getX(), message.getY())));
                            break;
                        case "lcm":
                            socket.write(String.valueOf(Calculator.gcd(message.getX(), message.getY())));
                            break;
                        case "echo":
                            socket.write(message.getData());
                            break;
                        default:
                            socket.write("ERROR");
                            exit = true;
                            break;
                    }
                } else {
                    System.out.println("NULL message");
                    return;
                }
            }
            close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    public void close() throws IOException {
        exit = true;
        socket.close();
    }

    public void kill() {
        this.interrupt();
    }

}
