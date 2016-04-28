package main;

import IceStorm.TopicExists;
import chat.ChatListenerPrx;
import chat.ChatListenerPrxHelper;
import chat.Contribution;

import java.util.Scanner;

import static java.lang.System.in;

/**
 * CHAT USING ICESTORM
 *
 * Speaker - main thread.
 *
 * @author urko
 */
public class Speaker extends Ice.Application {

    private String username;
    private Scanner keyboard;
    private Ice.Communicator communicator;
    private IceStorm.TopicPrx topicPrx;
    private IceStorm.TopicManagerPrx topicManagerPrx;
    private Contribution contribution;
    private ChatListenerPrx chat;

    public Speaker() {
        keyboard = new Scanner(in);
        configure();
    }

    @Override
    public int run(String [] strings) {
        communicator = Ice.Util.initialize(strings);
        contribution = new Contribution();
        topicManagerPrx = IceStorm.TopicManagerPrxHelper.checkedCast(communicator.stringToProxy("IceStorm/TopicManager:tcp -p " + strings[0]));
        int option;
        while ((option = menu()) != 0) {
            switch (option) {
                case 1:
                    System.out.print("\tEnter the topic name: ");
                    try {
                        topicPrx = topicManagerPrx.create(keyboard.nextLine());
                    } catch (TopicExists topicExists) {
                        System.out.println("ERROR: Topic already exists.");
                        break;
                    }
                    chat = ChatListenerPrxHelper.uncheckedCast(topicPrx.getPublisher());
                    break;
                case 2:
                    if (chat == null) {
                        System.out.println("ERROR: You MUST create a topic first.");
                        break;
                    }
                    System.out.print("\tEnter the message: ");
                    contribution.content = keyboard.nextLine();
                    chat.report(contribution);
                    break;
                default:
                    break;
            }
        }
        destroyService();
        return 0;
    }

    private void configure() {
        System.out.print("CONFIGURATION: Enter your username -> ");
        this.username = keyboard.nextLine();
    }

    private void destroyService() {
        communicator.destroy();
    }

    private int menu() {
        System.out.println("Hi " + username + ", select an option:");
        System.out.println("\t1) Create a topic.");
        System.out.println("\t2) Send a message.");
        System.out.println("\t0) Exit");
        System.out.print("Enter an option: ");
        return keyboard.nextInt();
    }

    /**
     * MAIN
     *
     * Usage: Enter the port you want to run in the first parameter of "args".
     *
     * @param args
     */
    public static void main(String [] args) {
        Speaker speaker = new Speaker();
        speaker.run(args);
    }

}
