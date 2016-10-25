package server;

import calc.Functions;
import data.Message;

/**
 * Created by urko on 15/02/16.
 */
public class CalcServer {

    public String calculate(Message msg) {
        if (msg.getType() == null) {
            return null;
        }
        Functions fun = new Functions();
        String result = null;
        switch (msg.getType()) {
            case "gdc":
                result = String.valueOf(fun.gcd(msg.getX(), msg.getY()));
                break;
            case "lcm":
                result = String.valueOf(fun.lcm(msg.getX(), msg.getY()));
                break;
            default:
        }
        return result;
    }

}
