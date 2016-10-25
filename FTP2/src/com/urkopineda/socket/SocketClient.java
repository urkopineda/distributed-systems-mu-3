package com.urkopineda.socket;

import java.io.*;
import java.net.Socket;

/**
 * Created by urko on 27/02/16.
 */
public class SocketClient {

    private Socket socket;
    private File file;

    private InputStream input;
    private OutputStream output;

    private String address;
    private int port;

    public SocketClient(String address, int port) {
        this.address = address;
        this.port = port;
        connect();
    }

    private void connect() {
        try {
            socket = new Socket(address, port);
            output = socket.getOutputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void uploadFile(String path) {
        file = new File(path);
        try {
            input = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        byte[] bytes = new byte[16 * 1024];
        int count;
        try {
            while ((count = input.read(bytes)) > 0) {
                output.write(bytes, 0, count);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } close();
    }

    public void close() {
        try {
            output.close();
            input.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
