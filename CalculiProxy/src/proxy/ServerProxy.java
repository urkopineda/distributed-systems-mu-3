package proxy;

import server.CalcServer;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.SocketTimeoutException;
import java.util.ArrayList;

/**
 * Created by urko on 15/02/16.
 */
public class ServerProxy {

    private ServerSocket s;
    private ArrayList<CalcServer> array;

    private int port;

    public ServerProxy(int port) {
        this.port = port;
        array = new ArrayList<>();
    }

    public void start() {
        createSocket();
        while (true) {
            try {
                System.out.print("Waiting connections... ");
                s.setSoTimeout(15000);
                try {
                    createCalculator(s);
                } catch (SocketTimeoutException e) {
                    if (!checkThreads()) {
                        System.out.println("Timeout. Bye!");
                        close();
                        return;
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void createSocket() {
        try {
            s = new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createCalculator(ServerSocket s) throws IOException {
        CalcServer calc = new CalcServer(s.accept());
        System.out.println("Client connected!");
        array.add(calc);
        calc.start();
    }

    private boolean checkThreads() {
        for (int i = 0; i < array.size(); i++) {
            CalcServer c = array.get(i);
            if (!c.getState().equals(Thread.State.TERMINATED)) return true;
        } return false;
    }

    private void close() {
        try {
            s.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
