package edu.mondragon.urkopineda.main;

import edu.mondragon.urkopineda.socket_udp.SocketServer;

import java.io.IOException;
import java.util.Scanner;

/**
 * Main thread of a server.
 *
 * @author urko
 */
public class Server {

    public static void main(String [] args) {
        SocketServer server = new SocketServer(6666);
        server.start();
        Scanner keyboard = new Scanner(System.in);
        keyboard.nextLine();
        try {
            server.close();
        } catch (IOException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

}
