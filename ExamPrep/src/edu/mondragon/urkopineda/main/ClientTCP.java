package edu.mondragon.urkopineda.main;

import edu.mondragon.urkopineda.socket_tcp.SocketClient;

/**
 * Main thread of a client.
 *
 * @author urko
 */
public class ClientTCP {

    public static void main(String [] args) {
        SocketClient client = new SocketClient("localhost", 6666);
        client.start();
    }

}
