package edu.mondragon.urkopineda.main;

import edu.mondragon.urkopineda.data.Buzon;
import edu.mondragon.urkopineda.socket.SocketClient;
import edu.mondragon.urkopineda.socket.SocketServer;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * A TCP Interceptor.
 *
 * @author urko
 */
public class Interceptor {

    public static void main(String [] args) {
        String address;
        int port, serverPort;
        try {
            port = Integer.parseInt(args[0]);
            address = args[1];
            serverPort = Integer.parseInt(args[2]);
        } catch (InputMismatchException e) {
            System.out.printf("ERROR: Typed input is not valid.");
            return;
        } catch (Exception e) {
            System.out.printf("ERROR: Server needs <PORT> <SERVER_ADDRESS> <SERVER_PORT> to create a socket.");
            return;
        }
        System.out.print("TCP INTERCEPTOR: Starting... ");
        Buzon<String> b1 = new Buzon<>(1000);
        Buzon<String> b2 = new Buzon<>(1000);
        SocketServer server = new SocketServer(port, b1, b2);
        server.start();
        SocketClient client = new SocketClient(address, serverPort, b1, b2);
        client.start();
        System.out.println("OK!");
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please, enter RETURN to quit the interceptor.");
        keyboard.nextLine();
        System.out.print("Closing interceptor...");
        try {
            server.close();
            client.close();
        } catch (IOException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
        System.out.print("OK!");
    }

}
