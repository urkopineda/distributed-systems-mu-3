package proxy;

import data.Message;
import server.CalcServer;
import socket.ServerSocket;

import java.net.DatagramPacket;

/**
 * Created by urko on 15/02/16.
 */
public class ServerProxy {

    private ServerSocket s;

    public ServerProxy(int port) {
        s = new ServerSocket(port);
    }

    public void start() {
        s.connect();
        boolean isSomeoneAlive = true;
        while (isSomeoneAlive) {
            CalcServer calc = new CalcServer();
            DatagramPacket packet = s.waitCommand(1024);
            Message msg = new Message(packet.getData().toString());
            String result = calc.calculate(msg);
            s.send(result, packet);
        }
    }

}
