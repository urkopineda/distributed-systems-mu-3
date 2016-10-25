package com.urkopineda.socket;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by urko on 23/02/16.
 */
public class SocketClient extends Thread {

    private Scanner keyboard;

    private String address;
    private int socket;

    private Socket s;
    private DataInputStream input;
    private PrintWriter output;

    public SocketClient(String address, int socket) {
        this.address = address;
        this.socket = socket;
        keyboard = new Scanner(System.in);
    }

    public void start() {
        System.out.println("WELCOME!");
        System.out.println("Type 'exit' to quit the program.");
        System.out.print("Connecting to the server... ");
        try {
            s = new Socket(address, socket);
            output = new PrintWriter(s.getOutputStream(), true);
            input = new DataInputStream(s.getInputStream());
        } catch (IOException e) {
            System.out.print("ERROR: " + e.getMessage());
            return;
        } System.out.println("Connected!");
        String file, path;
        do {
            System.out.print("What file do you want to download? ");
            file = keyboard.nextLine();
            System.out.print("In which path? ");
            path = keyboard.nextLine();
            if (!file.equals("exit")) {
                try {
                    System.out.print("Asking the server for the file... ");
                    output.println(file);
                    output.flush();
                    ArrayList<byte []> data = new ArrayList<>();
                    int j = input.readInt();
                    int size = 0;
                    for (int i = 0; i < j; i++) {
                        int l = input.readInt();

                        byte [] array = in
                    }
                    int length = dIn.readInt();                    // read length of incoming message
                    if(length>0) {
                        byte[] message = new byte[length];
                        dIn.readFully(message, 0, message.length); // read the message
                    }

                    FileOutputStream fos = new FileOutputStream(path);
                    fos.write(null);
                    fos.close();
                } catch (InputMismatchException e) {
                    System.out.println("ERROR: " + e.getMessage());
                } catch (IOException e) {
                    System.out.println("ERROR: " + e.getMessage());
                } catch (NumberFormatException e) {
                    System.out.println("ERROR: " + e.getMessage());
                }
            } else {
                closeServer();
            }
        } while (!command.equals("exit"));
        close();
        System.out.println("Bye!");
    }

    private void closeServer() {
        output.println("null");
        output.flush();
    }

    public void close() {
        try {
            s.close();
            input.close();
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
