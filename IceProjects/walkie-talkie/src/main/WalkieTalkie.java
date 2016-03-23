package main;

import engine.WTEngine;
import walkietalkie.WTPrx;
import walkietalkie.WTPrxHelper;

/**
 * Created by urko on 22/03/16.
 */
public class WalkieTalkie {

    private final String identity = "WalkieTalkie";
    private String address;
    private int port;

    private Ice.Communicator communicator;
    private Ice.ObjectAdapter adapter;
    private WTPrx proxy;

    public WalkieTalkie(String address, int port) {
        this.address = address;
        this.port = port;
    }

    public void start() {
        communicator = Ice.Util.initialize();
        adapter = communicator.createObjectAdapterWithEndpoints("", "tcp -h " + address + " -p " + port);
        adapter.add(new WTEngine(), communicator.stringToIdentity(identity));
        adapter.activate();
        boolean exists = false;
        while (!exists) {
            try {
                proxy = WTPrxHelper.checkedCast(
                        communicator.stringToProxy(identity + ": tcp -h " + address + " -p " + port)
                );
                exists = true;
            } catch (Exception e) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }

    public static void main(String [] args) {

    }

}
