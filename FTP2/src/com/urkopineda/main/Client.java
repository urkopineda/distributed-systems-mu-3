package com.urkopineda.main;

import com.urkopineda.socket.SocketClient;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by urko on 24/02/16.
 */
public class Client {

    public static void main(String [] args) {
        String address;
        int port;
        try {
            address = args[0];
            port = Integer.parseInt(args[1]);
        } catch (InputMismatchException e) {
            System.out.printf("ERROR: Typed input is not valid.");
            return;
        } catch (Exception e) {
            System.out.printf("ERROR: Client needs a concrete port and an addres to connect to. Please enter <ADDRESS>" +
                              "<PORT> as arguments.");
            return;
        }
        SocketClient sc = new SocketClient(address, port);
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter the file location: ");
        String path = keyboard.nextLine();
        sc.uploadFile(path);
        System.out.print("Sent!");
    }

}
