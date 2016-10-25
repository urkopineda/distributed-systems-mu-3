package com.urkopineda.main;

import com.urkopineda.socket.SocketServer;

import java.util.InputMismatchException;

/**
 * FTP Server main class.
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
            System.out.printf("ERROR: Server needs a concrete port to create a socket, please enter a socket number " +
                              "as argument.");
            return;
        }
        SocketServer server = new SocketServer(port);
        server.start();
    }

}
