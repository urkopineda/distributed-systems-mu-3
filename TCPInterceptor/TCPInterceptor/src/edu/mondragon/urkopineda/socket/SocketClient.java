package edu.mondragon.urkopineda.socket;

import edu.mondragon.urkopineda.data.Buzon;

import java.io.IOException;
import java.net.Socket;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * A TCP socket client.
 *
 * @author urko
 */
public class SocketClient extends Thread {

    private Socket socket;
    private SocketUtils utils;
    private String address;
    private int port;
    private boolean exit;

    private Buzon<String> b1;
    private Buzon<String> b2;

    public SocketClient(String address, int port, Buzon<String> b1, Buzon<String> b2) {
        this.address = address;
        this.port = port;
        this.b1 = b1;
        this.b2 = b2;
    }

    @Override
    public void run() {
        try {
            String message;
            connect();
            utils = new SocketUtils(socket);
            utils.createIO();
            while (!exit) {
                message = b2.receive();
                System.out.println("INTERCEPTOR CLIENT: Client sends to server: " + message);
                utils.write(message);
                message = utils.read();
                System.out.println("INTERCEPTOR CLIENT: Server sends to client: " + message);
                b1.send(message);
            }
        } catch (IOException e) {
            System.out.println("ERROR: " + e.getMessage());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void connect() throws IOException {
        socket = new Socket(address, port);
    }

    public void close() {
        exit = true;
        try {
            utils.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
