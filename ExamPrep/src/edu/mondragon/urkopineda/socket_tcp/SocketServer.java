package edu.mondragon.urkopineda.socket_tcp;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;

/**
 * A TCP socket server.
 *
 * @author urko
 */
public class SocketServer extends Thread {

    private ServerSocket socket;
    private ArrayList<SocketAttender> attenders;
    private int port;

    boolean exit = false;

    public SocketServer(int port) {
        this.port = port;
        attenders = new ArrayList<>();
    }

    @Override
    public void run() {
        try {
            connect();
            while (!exit) {
                SocketAttender attender = new SocketAttender(socket.accept());
                attenders.add(attender);
                attender.start();
            }
        } catch (IOException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    public void connect() throws IOException {
        socket = new ServerSocket(port);
    }

    public void close() throws IOException {
        exit = true;
        for (int i = 0; i < attenders.size(); i++) {
            SocketAttender attender = attenders.get(i);
            attender.close();
            try {
                attender.join();
            } catch (InterruptedException e) {
                System.out.println("ERROR: " + e.getMessage());
            }
        }
        socket.close();
        this.interrupt();
    }

}
