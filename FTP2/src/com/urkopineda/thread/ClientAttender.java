package com.urkopineda.thread;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by urko on 24/02/16.
 */
public class ClientAttender extends Thread {

    private Socket s;
    private InputStream input;
    private OutputStream output;

    public ClientAttender(Socket s) {
        this.s = s;
    }

    @Override
    public void run() {
        createInputSocket();
        Scanner keyboard = new Scanner(System.in);
        System.out.print("File is being received, please enter a path + file name: ");
        String path = keyboard.nextLine();
        createOutputFile(path);
        byte [] fileBytes = new byte[16 * 1024];
        int count;
        try {
            while ((count = input.read(fileBytes)) > 0) {
                output.write(fileBytes, 0, count);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("File created.");
        close();
    }

    private void createInputSocket() {
        try {
            input = s.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createOutputFile(String file) {
        try {
            output = new FileOutputStream(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void close() {
        try {
            input.close();
            output.close();
            s.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
