package engine;

import chat.ChatEngine;
import utils.ChatManagerPrx;
import utils.ChatManagerPrxHelper;
import utils.ClientPrx;
import utils.ClientPrxHelper;

import java.util.Scanner;

/**
 * Chat engine used by client.
 *
 * @author urko
 */
public class ClientEngine {

    private Scanner keyboard;

    private String address;
    private int port;

    private final String identity = "ChatRoom";

    private Ice.Communicator ic;
    private Ice.ObjectAdapter adapter;
    private ChatManagerPrx proxy;
    private ClientPrx cproxy;

    public ClientEngine(String address, int port) {
        this.address = address;
        this.port = port;
        keyboard = new Scanner(System.in);
    }

    public void start() {
        ic = Ice.Util.initialize();
        adapter = ic.createObjectAdapterWithEndpoints(identity, "tcp -h 127.0.0.1 -p 0");
        cproxy = ClientPrxHelper.checkedCast(adapter.addWithUUID(new ChatEngine()));
        proxy = ChatManagerPrxHelper.checkedCast(ic.stringToProxy(identity + ": tcp -h " + address + " -p " + port));
        adapter.activate();
        proxy.subscribe(keyboard.nextLine(), cproxy);
        String command = null;
        do {
            command = keyboard.nextLine();
            proxy.write(0, command);
        } while (!command.equals("exit"));
    }

}
