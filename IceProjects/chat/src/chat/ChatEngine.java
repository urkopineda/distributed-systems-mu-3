package chat;

import Ice.Current;
import utils._ClientDisp;

/**
 * Created by urko on 15/03/16.
 */
public class ChatEngine extends _ClientDisp {

    @Override
    public void read(String message, Current __current) {
        System.out.println(message);
    }

}
