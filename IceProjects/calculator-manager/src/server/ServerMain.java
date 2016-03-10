package server;

import utils.CalculatorPrx;
import utils.CalculatorPrxHelper;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * ICE Server using a CalculatorPrx and a CalculatorManagerPrx.
 *
 * @author urko
 */
public class ServerMain {

    private final String calcIdentity = "Calculator";
    private final String managerIdentity = "Manager";

    private int port;
    private int calcNumber;

    private Ice.Communicator ic;
    private Ice.ObjectAdapter adapter;

    ArrayList<CalculatorPrx> list = new ArrayList<>();

    public ServerMain(int port, int calcNumber) {
        this.port = port;
        this.calcNumber = calcNumber;
    }

    public void start() {
        ic = Ice.Util.initialize();
        adapter = ic.createObjectAdapterWithEndpoints("", "tcp -p " + port);
        for (int i = 0; i < calcNumber; i++) {
            list.add(CalculatorPrxHelper.checkedCast(adapter.add(new calc.Calculator(), ic.stringToIdentity(calcIdentity + i))));
        }
        adapter.add(new calc.Manager(list), ic.stringToIdentity(managerIdentity));
        adapter.activate();
    }

    public void close() {
        ic.destroy();
    }

    public static void main(String [] args) {
        if (((args[0] != null) && (args[0].equals(""))) || ((args[1] != null) && (args[1].equals("")))) {
            System.out.println("ERROR: Give an argument to specify the port of the server and the number of " +
                               "calculators.");
            return;
        } else {
            ServerMain server = new ServerMain(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
            server.start();
            Scanner keyboard = new Scanner(System.in);
            keyboard.nextLine();
            keyboard.close();
            server.close();
        }
    }

}
