package main;

import proxy.ArbiterProxy;

import java.util.Scanner;

/**
 * Created by urko on 26/04/16.
 */
public class Arbiter extends Ice.Application {

    private String address = "127.0.0.1";
    private final String adapterName = "SharedResource";
    private final String proxyName = "SharedProxy";
    private Scanner keyboard;

    private Ice.Communicator communicator;
    private Ice.ObjectAdapter adapter;
    private ArbiterProxy proxy;

    public Arbiter() {
        keyboard = new Scanner(System.in);
    }

    @Override
    public int run(String[] strings) {
        System.out.println("Arbiter starting in address " + address + " and port " + strings[0]);
        communicator = Ice.Util.initialize();
        adapter = communicator.createObjectAdapterWithEndpoints(adapterName, "tcp -h " + address + " -p " + strings[0]);
        proxy = new ArbiterProxy();
        adapter.add(proxy, communicator.stringToIdentity(proxyName));
        adapter.activate();
        System.out.println("Arbiter working, please press RETURN to finish the arbiter...");
        keyboard.nextLine();
        communicator.destroy();
        System.out.println("Arbiter stopped.");
        return 0;
    }

    public static void main(String [] args) {
        Arbiter arbiter = new Arbiter();
        arbiter.run(args);
    }

}
