package client;

import utils.CalculatorManagerPrx;
import utils.CalculatorManagerPrxHelper;
import utils.CalculatorPrx;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * ICE Client using a CalculatorPrx and a CalculatorManagerPrx.
 *
 * @author urko
 */
public class ClientMain {

    private String address;
    private int port;

    private Ice.Communicator ic;
    private CalculatorManagerPrx manager;

    public ClientMain(String address, int port) {
        this.address = address;
        this.port = port;
    }

    public void start() {
        ic = Ice.Util.initialize();
        manager = CalculatorManagerPrxHelper.checkedCast(ic.stringToProxy("Manager: tcp -h " + address + " -p " + port));
        Scanner keyboard = new Scanner(System.in);
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
                    CalculatorPrx calculator = manager.giveMeOneCalculatorReference();
                    switch (command.toLowerCase()) {
                        case "gcd":
                            System.out.println("  The result is: " + calculator.gcd(x, y));
                            break;
                        case "lcm":
                            System.out.println("  The result is: " + calculator.lcm(x, y));
                            break;
                        case "exit":
                            break;
                        default:
                            System.out.println("ERROR: Invalid command.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("ERROR: " + e.getMessage());
                }
            }
        } while (!command.equals("exit"));
        keyboard.close();
    }

    public void close() {
        ic.destroy();
    }

    public static void main(String [] args) {
        if (((args[0] != null) && (args[0].equals(""))) || ((args[1] != null) && (args[1].equals("")))) {
            System.out.println("ERROR: Give an argument to specify the address and the port of the server.");
            return;
        } else {
            ClientMain client = new ClientMain(args[0], Integer.parseInt(args[1]));
            client.start();
            client.close();
        }
    }

}
