package proxy;

import calc.Calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by urko on 15/02/16.
 */
public class ClientProxy implements Calculator {

    private Scanner keyboard;

    private String address;
    private int socket;

    private Socket s;
    private BufferedReader input;
    private PrintWriter output;

    public ClientProxy(String address, int socket) {
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
            input = new BufferedReader(new InputStreamReader(s.getInputStream()));
        } catch (IOException e) {
            System.out.print("ERROR: " + e.getMessage());
            return;
        } System.out.println("Connected!");
        String command;
        do {
            System.out.print("What do you want me to calculate? (GCD or LCM): ");
            command = keyboard.nextLine();
            long x, y;
            if (!command.equals("exit")) {
                try {
                    System.out.print("  Give me the first number: ");
                    x = keyboard.nextLong();
                    keyboard.nextLine();
                    System.out.print("  Give me the second number: ");
                    y = keyboard.nextLong();
                    keyboard.nextLine();
                    switch (command.toLowerCase()) {
                        case "gcd":
                            System.out.println("  The result is: " + gdc(x, y));
                            break;
                        case "lcm":
                            System.out.println("  The result is: " + lcm(x, y));
                            break;
                        case "exit":
                            break;
                        default:
                            System.out.println("ERROR: Invalid command.");
                    }
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

    @Override
    public long gdc(long x, long y) throws IOException {
        output.println("gdc(" + x + "," + y + ")$");
        output.flush();
        return Long.parseLong(input.readLine());
    }

    @Override
    public long lcm(long x, long y) throws IOException {
        output.println("lcm(" + x + "," + y + ")$");
        output.flush();
        return Long.parseLong(input.readLine());
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
