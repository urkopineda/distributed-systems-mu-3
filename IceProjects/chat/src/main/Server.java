package main;

import engine.ServerEngine;

import java.util.InputMismatchException;

/**
 * Server ice - Initialize the engine to create ice groups.
 *
 * @author urko
 */
public class Server {

    private int port;

    public Server(int port) {
        this.port = port;
    }

    public void start() {
        ServerEngine engine = new ServerEngine(port);
        engine.start();
    }

    public static void main(String [] args) {
        int port;
        try {
            port = Integer.parseInt(args[0]);
        } catch (InputMismatchException e) {
            System.out.println("ERROR: Define the port number as an argument.");
            return;
        }
        Server server = new Server(port);
        server.start();
    }

}
