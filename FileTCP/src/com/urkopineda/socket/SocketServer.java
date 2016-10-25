package com.urkopineda.socket;

import com.urkopineda.file.FileServer;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.SocketTimeoutException;

/**
 * Created by urko on 23/02/16.
 */
public class SocketServer extends Thread {

    private ServerSocket s;
    private int port;

    public SocketServer(int port) {
        this.port = port;
    }

    public void init() {
        create();
        while (true) {
            try {
                System.out.print("Waiting connections... ");
                s.setSoTimeout(60000);
                try {
                    FileServer f = new FileServer(this, s.accept());
                    f.start();
                } catch (SocketTimeoutException e) {
                    System.out.println("Timeout. Bye!");
                    close();
                    return;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void create() {
        try {
            s = new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void close() {
        try {
            s.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String read(BufferedReader input) {
        String command = "";
        try {
            boolean hasEnded;
            do {
                command += input.readLine();
                hasEnded = command.contains("$");
            } while (!hasEnded);
            return command;
        } catch (IOException e) {
            e.printStackTrace();
        } return null;
    }

    public void write(DataOutputStream output, byte [] array) throws IOException {
        output.write(array);
    }

    public void write(DataOutputStream output, int num) throws IOException {
        output.write(num);
    }

}
