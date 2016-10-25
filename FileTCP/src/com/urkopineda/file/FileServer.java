package com.urkopineda.file;

import com.urkopineda.data.Message;
import com.urkopineda.socket.SocketServer;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

/**
 * Created by urko on 23/02/16.
 */
public class FileServer extends Thread {

    private SocketServer server;
    private Socket s;
    private DataOutputStream output;
    private BufferedReader input;
    private String path;

    public FileServer(SocketServer server, Socket s) {
        this.server = server;
        this.s = s;
    }

    @Override
    public void run() {
        connect(s);
        path = server.read(input);
        ArrayList<byte []> data = null;
        try {
            Message msg = new Message();
            data = msg.insertFile(open());
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (data != null) {
            try {
                server.write(output, data.size());
                for (int i = 0; i < data.size(); i++) {
                    byte [] array = data.get(i);
                    server.write(output, array.length);
                    server.write(output, array);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else try {
            server.write(output, -1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public FileInputStream open() {
        FileInputStream input = null;
        try {
            input = new FileInputStream(path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } return input;
    }

    public void connect(Socket s) {
        try {
            output = new DataOutputStream(s.getOutputStream());
            input = new BufferedReader(new InputStreamReader(s.getInputStream()));
        } catch (IOException e) {
            System.out.println("ERROR: " + e.getMessage());
            return;
        }
    }

}
