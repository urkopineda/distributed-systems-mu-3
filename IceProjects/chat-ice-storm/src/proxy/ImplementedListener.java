package proxy;

import Ice.Current;
import chat.Contribution;

/**
 * A listener proxy, implemeted from de code generated from SLICE.
 *
 * @author urko
 * @see chat._ChatListenerDisp
 */
public class ImplementedListener extends chat._ChatListenerDisp{

    @Override
    public void report(Contribution c, Current __current) {
        System.out.println("MESSAGE: " + c.content);
    }

}
