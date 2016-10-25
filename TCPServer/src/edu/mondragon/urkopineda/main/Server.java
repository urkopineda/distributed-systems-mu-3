package edu.mondragon.urkopineda.main;

import edu.mondragon.urkopineda.socket.SocketServer;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * A simple TCP Server.
 *
 * @author urko
 */
public class Server {

    public static void main(String [] args) {
        int port;
        try {
            port = Integer.parseInt(args[0]);
        } catch (InputMismatchException e) {
            System.out.printf("ERROR: Typed input is not valid.");
            return;
        } catch (Exception e) {
            System.out.printf("ERROR: Server needs <PORT> to create a socket.");
            return;
        }
        System.out.print("TCP SERVER: Starting... ");
        SocketServer server = new SocketServer(port);
        server.start();
        System.out.println("OK!");
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please, enter RETURN to quit the server.");
        keyboard.nextLine();
        System.out.print("Closing server...");
        try {
            server.close();
        } catch (IOException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
        System.out.print("OK!");
    }

}
