package chat;

import Ice.Current;
import forum._ListenerDisp;

/**
 * Created by urko on 5/04/16.
 */
public class ChatListener extends _ListenerDisp {

    @Override
    public void newPublication(String str, Current __current) {
        System.out.println(str);
    }

}
