package com.urkopineda.socket;

import com.urkopineda.thread.ClientAttender;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.SocketException;
import java.util.ArrayList;

/**
 * Created by urko on 24/02/16.
 */
public class SocketServer {

    private ArrayList<ClientAttender> threadList;

    private ServerSocket socket;
    private int port;
    private int timeout = 60000;

    public SocketServer(int port) {
        threadList = new ArrayList<>();
        this.port = port;
    }

    public void start() {
        connect();
        boolean exit = false;
        do {
            try {
                socket.setSoTimeout(timeout);
                ClientAttender attender = new ClientAttender(socket.accept());
                attender.start();
                threadList.add(attender);
            } catch (SocketException e) {
                System.out.println("Server has received no clients in " + (timeout / 100) + " seconds.");
                timeout /= 2;
                if (timeout < 5) exit = true;
            } catch (IOException e) {
                System.out.println("ERROR: " + e.getMessage());
                System.out.println("Closing server.");
            }
        } while (!exit);
        close();
    }

    public void connect() {
        try {
            socket = new ServerSocket(port);
        } catch (IOException e) {
            System.out.println("ERROR: " + e.getMessage());
            System.out.println("Closing server.");
            return;
        }
    }

    public void close() {
        try {
            System.out.println("Closing server.");
            for (int i = 0; i < threadList.size(); i++) {
                threadList.get(i).close();
            }
            for (int i = 0; i < threadList.size(); i++) {
                threadList.get(i).join();
            }
            socket.close();
        } catch (IOException e) {
            System.out.println("ERROR: " + e.getMessage());
        } catch (InterruptedException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

}
