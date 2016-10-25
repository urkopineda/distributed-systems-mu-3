package edu.mondragon.urkopineda.socket_udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * A UDP socket server.
 *
 * @author urko
 */
public class SocketServer extends Thread {

    private DatagramSocket socket;
    private int port;

    boolean exit = false;

    public SocketServer(int port) {
        this.port = port;
    }

    @Override
    public void run() {
        try {
            byte [] buffer;
            connect();
            while (!exit) {
                buffer = new byte[256];
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                socket.receive(packet);
                SocketAttender attender = new SocketAttender(packet, socket);
                attender.start();
            }
        } catch (IOException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    private void connect() throws IOException {
        socket = new DatagramSocket(port);
    }

    public void close() throws IOException {
        exit = true;
        socket.close();
        this.interrupt();
    }

}
