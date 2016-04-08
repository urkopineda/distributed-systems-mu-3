package main;

import java.util.Scanner;

/**
 * Created by urko on 7/04/16.
 */
public class Client extends Thread{

    private String [] config;
    private String myAdapterIdentity = "Chat2";
    private String hisAdapterIdentity = "Chat1";
    private String myIdentity = "Obj2";
    private String hisIdentity = "Obj1";

    private Ice.Communicator communicator;
    private Ice.ObjectAdapter adapter;
    private chat.ChatEnginePrx myProxy, hisProxy;

    public Client(String [] config) {
        this.config = config;
    }

    @Override
    public void start() {
        communicator = Ice.Util.initialize(config);
        adapter = communicator.createObjectAdapter(myAdapterIdentity);
        myProxy = chat.ChatEnginePrxHelper.checkedCast(adapter.add
                (new engine.ChatEngine(), communicator.stringToIdentity(myIdentity)));
        adapter.activate();
        hisProxy = chat.ChatEnginePrxHelper.checkedCast(
                communicator.stringToProxy(hisIdentity + "@" + hisAdapterIdentity));
    }

    private void write() {
        Scanner keyboard = new Scanner(System.in);
        String command;
        System.out.println("Type 'exit' to finish the connection.");
        while (true) {
            command = keyboard.nextLine();
            if (command.equals("exit")) break;
            else hisProxy.publish(command);
        }
    }

    public void kill() {
        communicator.destroy();
        this.interrupt();
    }

    public static void main(String [] args) {
        System.out.println("CHAT");
        if (args.length != 1) {
            System.out.println("ERROR: Command line must contain --Ice.config=\"someConfigFile\"");
        } else {
            Server server = new Server(args);
            server.start();
            try {
                server.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            server.kill();
            System.out.println("Bye!");
        }
    }

}
