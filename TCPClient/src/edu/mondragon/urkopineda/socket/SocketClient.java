package edu.mondragon.urkopineda.socket;

import edu.mondragon.urkopineda.data.Message;

import java.io.IOException;
import java.net.Socket;

/**
 * A TCP socket client.
 *
 * @author urko
 */
public class SocketClient {

    private Socket socket;
    private SocketUtils utils;
    private String address;
    private int port;

    public SocketClient(String address, int port) {
        this.address = address;
        this.port = port;
    }

    public void start() {
        Message message;
        try {
            connect();
            utils = new SocketUtils(socket);
            utils.createIO();
            message = new Message("gcd", 1, 2);
            System.out.println("Client sends: " + message.toString());
            utils.write(message);
            System.out.println("Server response: " + utils.read());
            message = new Message("lcm", 5, 20);
            System.out.println("Client sends: " + message.toString());
            utils.write(message);
            System.out.println("Server response: " + utils.read());
        } catch (IOException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    public void connect() throws IOException {
        socket = new Socket(address, port);
    }

    public void close() throws IOException {
        utils.close();
    }

}
