package engine;

import chat.ChatListener;
import forum.ListenerPrx;
import forum.ListenerPrxHelper;

import java.util.Scanner;

/**
 * Created by urko on 5/04/16.
 */
public class Engine {

    private final String identity = "IceChat";
    private final String chatIdentity = "ProxyChat";

    private Ice.Communicator communicator;
    private Ice.ObjectAdapter adapter;
    private ListenerPrx proxy;

    private Scanner keyboard;

    public Engine() {}

    public void start() {
        communicator = Ice.Util.initialize();
        adapter = communicator.createObjectAdapterWithEndpoints(identity, "udp -h 224.0.0.5 -p 6666");
        ListenerPrxHelper.checkedCast(adapter.add(new ChatListener(), communicator.stringToIdentity(chatIdentity)));
        proxy = ListenerPrxHelper.checkedCast(communicator.stringToProxy(chatIdentity + ": udp -h 224.0.0.5 -p 6666"));
        adapter.activate();
        chat();
        communicator.destroy();
    }

    private void chat() {
        String msg = null;
        keyboard = new Scanner(System.in);
        do {
            msg = keyboard.nextLine();
            if (!msg.equals("exit")) {
                proxy.newPublication(msg);
            }
        } while (!msg.equals("exit"));
    }

}
