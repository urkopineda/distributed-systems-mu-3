package socket;

import java.io.IOException;
import java.net.*;

/**
 * Created by urko on 18/02/16.
 */
public class ServerSocket {

    private java.net.ServerSocket socketTCP;
    private DatagramSocket socketUDP;
    private int port;

    public ServerSocket(int port) {
        this.port = port;
    }

    public void connect() {
        try {
            socketUDP = new DatagramSocket(port);
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    public DatagramPacket waitCommand(int bufferSize) {
        byte [] buffer = new byte[bufferSize];
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
        try {
            socketUDP.receive(packet);
        } catch (IOException e) {
            e.printStackTrace();
        } return packet;
    }

    public void send(String message, DatagramPacket packet) {
        DatagramPacket response = new DatagramPacket(message.getBytes(), message.getBytes().length,
                                                     packet.getAddress(), packet.getPort());
        try {
            socketUDP.send(response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
