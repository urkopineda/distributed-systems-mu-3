package edu.mondragon.urkopineda.socket_tcp;

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
        try {
            connect();
            utils = new SocketUtils(socket);
            utils.createIO();
            //
            Message message = utils.read();
            System.out.println(message.toString());
            utils.write(new Message("Que tal"));
            //
            utils.close();
        } catch (IOException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    public void connect() throws IOException {
        socket = new Socket(address, port);
    }

}
