package main;

import IceStorm.*;
import proxy.ImplementedListener;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * CHAT USING ICESTORM
 *
 * Listener - main thread.
 *
 * @author urko
 */
public class Listener extends Ice.Application {

    private final String adapterName = "ISAdapter";
    private final String identityName = "Chat";

    private Scanner keyboard;
    private Ice.Communicator communicator;
    private Ice.ObjectAdapter adapter;
    private IceStorm.TopicManagerPrx managerPrx;
    private IceStorm.TopicPrx topicPrx;
    private Map<String, IceStorm.TopicPrx> topics;
    private Ice.ObjectPrx subscriber;

    public Listener() {
        keyboard = new Scanner(System.in);
    }

    @Override
    public int run(String[] strings) {
        communicator = Ice.Util.initialize(strings);
        managerPrx = IceStorm.TopicManagerPrxHelper.checkedCast(communicator.stringToProxy("IceStorm/TopicManager:tcp -p " + strings[0]));
        listTopics();
        System.out.print("Choose a topic: ");
        try {
            topicPrx = managerPrx.retrieve(keyboard.nextLine());
        } catch (NoSuchTopic noSuchTopic) {
            noSuchTopic.printStackTrace();
            return 0;
        }
        adapter = communicator.createObjectAdapterWithEndpoints(adapterName, "tcp -h 127.0.0.1 -p " + strings[1]);
        Ice.Identity identity = new Ice.Identity(identityName, "");
        subscriber = adapter.add(new ImplementedListener(), identity);
        adapter.activate();
        Map<String, String> map = new HashMap<>();
        map.put("retryCount",  "ordered");
        try {
            topicPrx.subscribeAndGetPublisher(map, subscriber);
        } catch (AlreadySubscribed alreadySubscribed) {
            alreadySubscribed.printStackTrace();
        } catch (BadQoS badQoS) {
            badQoS.printStackTrace();
        } catch (InvalidSubscriber invalidSubscriber) {
            invalidSubscriber.printStackTrace();
        }
        destroyService();
        return 0;
    }

    private void listTopics() {
        topics = managerPrx.retrieveAll();
        for (Map.Entry<String, TopicPrx> entry: topics.entrySet()) {
            System.out.println("-- " + entry.getKey() + "/" + entry.getValue());
        }
    }

    private void  destroyService() {
        communicator.waitForShutdown();
        topicPrx.unsubscribe(subscriber);
    }

    /**
     * MAIN
     *
     * Usage: Enter the port of the speaker in the first parameter of "args" and the port you want to run on in the second parameter.
     *
     * @param args
     */
    public static void main(String args[]) throws IOException {
        Listener listener = new Listener();
        listener.run(args);
    }
}
