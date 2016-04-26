package proxy;

import Ice.Current;
import distributedSynchronization._ArbiterDisp;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by urko on 26/04/16.
 */
public class ArbiterProxy extends _ArbiterDisp {

    private Lock lock;
    private int counter = 0;

    public ArbiterProxy() {
        lock = new ReentrantLock();
    }

    @Override
    public boolean take(Current __current) {
        lock.lock();
        if (counter > 0) {
            lock.unlock();
            return false;
        } else counter++;
        lock.unlock();
        return true;
    }

    @Override
    public void give(Current __current) {
        lock.lock();
        counter--;
        if (counter < 0) counter = 0;
        lock.unlock();
    }

}
