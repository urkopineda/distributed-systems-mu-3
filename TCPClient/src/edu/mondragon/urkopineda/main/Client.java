package edu.mondragon.urkopineda.main;

import edu.mondragon.urkopineda.socket.SocketClient;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * A simple TCP Client.
 *
 * @author urko
 */
public class Client {

    public static void main(String [] args) {
        String address;
        int port;
        try {
            address = args[0];
            port = Integer.parseInt(args[1]);
        } catch (InputMismatchException e) {
            System.out.printf("ERROR: Typed input is not valid.");
            return;
        } catch (Exception e) {
            System.out.printf("ERROR: Client needs <ADDRESS> <PORT> to connect to a socket.");
            return;
        }
        System.out.println("TCP CLIENT: Running...");
        SocketClient client = new SocketClient(address, port);
        client.start();
        System.out.print("Closing client... ");
        try {
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("OK!");
    }

}
