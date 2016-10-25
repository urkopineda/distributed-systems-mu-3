package com.urkopineda.main;

import com.urkopineda.socket.SocketServer;

/**
 * Created by urko on 23/02/16.
 */
public class Server {

    public static void main(String [] args) {
        SocketServer server = new SocketServer(Integer.parseInt(args[0]));
        server.init();
    }

}
