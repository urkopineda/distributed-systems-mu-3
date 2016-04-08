package engine;

import Ice.Current;

/**
 * Created by urko on 7/04/16.
 */
public class ChatEngine extends chat._ChatEngineDisp {
    @Override
    public void publish(String message, Current __current) {
        System.out.println(message);
    }
}
