package edu.mondragon.urkopineda.socket_udp;

import edu.mondragon.urkopineda.data.Message;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * A UDP socket client.
 *
 * @author urko
 */
public class SocketClient {

    private DatagramSocket socket;
    private InetAddress address;
    private int port;

    public SocketClient(String address, int port) {
        try {
            this.address = InetAddress.getByName(address);
        } catch (UnknownHostException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
        this.port = port;
    }

    public void start() {
        try {
            connect();
            //
            send(new Message("Hola"));
            Message message = receive();
            System.out.println(message.toString());
            //
            close();
        } catch (IOException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    public void connect() throws IOException {
        socket = new DatagramSocket();
    }

    public void send(Message message) {
        DatagramPacket packet = new DatagramPacket(message.getBytes(),
                                                   message.getBytes().length,
                                                   address,
                                                   port);
        try {
            socket.send(packet);
        } catch (IOException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    public Message receive() {
        byte[] buffer = new byte[1000];
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
        try {
            socket.receive(packet);
        } catch (IOException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
        return new Message(packet.getData());
    }

    public void close() {
        socket.close();
    }

}
