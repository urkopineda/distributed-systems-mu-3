package main;

import distributedSynchronization.ArbiterPrx;
import distributedSynchronization.ArbiterPrxHelper;

import java.util.Scanner;

/**
 * Created by urko on 26/04/16.
 */
public class Adversary extends Ice.Application {

    private String address = "127.0.0.1";
    private final String proxyName = "SharedProxy";
    private Scanner keyboard;

    private Ice.Communicator communicator;
    private Ice.ObjectPrx inProxy;
    private ArbiterPrx proxy;

    public Adversary() {
        keyboard = new Scanner(System.in);
    }

    @Override
    public int run(String[] strings) {
        System.out.println("Adversary starting...");
        communicator = Ice.Util.initialize();
        inProxy = communicator.stringToProxy(proxyName + ":tcp -h " + address + " -p " + strings[0]);
        try {
            proxy = ArbiterPrxHelper.checkedCast(inProxy);
        } catch (Ice.ConnectFailedException e) {
            System.out.println("ERROR: There is no Arbiter, exiting adversary...");
            communicator.destroy();
            System.out.println("Adversary stopped.");
            return 0;
        }
        while (!proxy.take()) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Adversary " + strings[1] + " has taken the resource, press RETURN to leave the resource...");
        keyboard.nextLine();
        proxy.give();
        System.out.println("Adversary " + strings[1] + " has leave the resource.");
        communicator.destroy();
        System.out.println("Adversary stopped.");
        return 0;
    }

    public static void main(String [] args) {
        Adversary adversary= new Adversary();
        adversary.run(args);
    }
}
