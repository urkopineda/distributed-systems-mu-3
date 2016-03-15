package main;

import engine.ClientEngine;

import java.util.InputMismatchException;

/**
 * Client main - Initialize the connection using ICE and subscribe to a ice.
 *
 * @author urko
 */
public class Client {

    private String address;
    private int port;

    public Client(String address, int port) {
        this.address = address;
        this.port = port;
    }

    public void start() {
        ClientEngine engine = new ClientEngine(address, port);
        engine.start();
    }

    public static void main(String [] args) {
        String address;
        int port;
        try {
            address = args[0];
            port = Integer.parseInt(args[1]);
        } catch (InputMismatchException e) {
            System.out.println("ERROR: Define the port number as an argument.");
            return;
        }
        Client client = new Client(address, port);
        client.start();
    }

}
