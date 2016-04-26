package proxy;

import Ice.Current;
import distributedSynchronization._ArbiterDisp;

/**
 * Created by urko on 26/04/16.
 */
public class ArbiterProxy extends _ArbiterDisp {

    private int counter = 0;

    @Override
    public synchronized boolean take(Current __current) {
        if (counter > 0) {
            return false;
        } else {
            counter++;
            return true;
        }
    }

    @Override
    public synchronized void give(Current __current) {
        counter--;
        if (counter < 0) counter = 0;
    }

}
