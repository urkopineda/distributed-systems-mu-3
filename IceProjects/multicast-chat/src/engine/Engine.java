package engine;

import Ice.ObjectAdapter;
import Ice.ObjectPrx;
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
    private forum.ListenerPrx proxy;

    private Scanner keyboard;

    public Engine() {}

    public void start() {
        communicator = Ice.Util.initialize();
        adapter = communicator.createObjectAdapterWithEndpoints(identity, "udp -h 239.1.1.1 -p 10000");
        ListenerPrxHelper.checkedCast(adapter.add(new ChatListener(), communicator.stringToIdentity(chatIdentity)));
        ObjectPrx tempProxy = ListenerPrxHelper.checkedCast
                (communicator.stringToProxy(chatIdentity + ": udp -h 239.1.1.1 -p 10000 --ttl 2 --interface 172.17.")).ice_datagram();
        proxy = ListenerPrxHelper.checkedCast(tempProxy);
        adapter.activate();
        chat();
        communicator.destroy();
    }

    private void chat() {
        String msg;
        keyboard = new Scanner(System.in);
        do {
            msg = keyboard.nextLine();
            if (!msg.equals("exit")) {
                proxy.newPublication(msg);
            }
        } while (!msg.equals("exit"));
    }

}
