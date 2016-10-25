package edu.mondragon.urkopineda.socket_udp;

import edu.mondragon.urkopineda.data.Message;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * Thread that attends a client received from the SocketServer class.
 *
 * @author urko
 */
public class SocketAttender extends Thread {

    private DatagramPacket packet;
    private DatagramSocket socket;

    public SocketAttender(DatagramPacket packet, DatagramSocket socket) {
        this.packet = packet;
        this.socket = socket;
    }

    @Override
    public void run() {
        //
        Message receivedMessage = receive();
        System.out.println(receivedMessage.toString());
        send(new Message("Que tal"));
        //
    }

    private void send(Message message) {
        try {
            socket.send(new DatagramPacket(message.getBytes(),
                                           message.getBytes().length,
                                           packet.getAddress(),
                                           packet.getPort()));
        } catch (IOException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    private Message receive() {
        return new Message(packet.getData());
    }

}
