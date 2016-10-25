package socket;

import java.io.*;
import java.net.*;

/**
 * Created by urko on 18/02/16.
 */
public class ClientSocket {

    InetAddress address;
    int port;
    DatagramSocket s;

    public ClientSocket(String address, int port) {
        try {
            this.address = InetAddress.getByName(address);
            this.port = port;
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    public void connect() {
        try {
            s = new DatagramSocket();
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    public void send(String message) {
        DatagramPacket pkg = new DatagramPacket(message.getBytes(),
                                                message.getBytes().length,
                                                address, port);
        try {
            s.send(pkg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String receive() {
        byte[] receiveData = new byte[1024];
        DatagramPacket pkg = new DatagramPacket(receiveData, receiveData.length);
        try {
            s.receive(pkg);
        } catch (IOException e) {
            e.printStackTrace();
        } return pkg.getData().toString();
    }

    public void close() {
        s.close();
    }

}
