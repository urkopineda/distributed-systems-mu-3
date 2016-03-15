package chat;

import Ice.Current;
import data.User;
import utils.ClientPrx;
import utils._ChatManagerDisp;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by urko on 15/03/16.
 */
public class ChatManager extends _ChatManagerDisp {

    private int counter = 0;
    private HashMap<Integer, User> map;

    public ChatManager() {
        map = new HashMap<>();
    }

    @Override
    public int subscribe(String name, ClientPrx client, Current __current) {
        map.put(counter++, new User(client, name));
        return counter;
    }

    @Override
    public void unsubscribe(int id, Current __current) {
        map.remove(id);
    }

    @Override
    public void write(int id, String message, Current __current) {
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            if ((Integer) pair.getKey() != id) {
                ClientPrx proxy = ((User) (pair.getValue())).getProxy();
                proxy.read(message);
            }
            it.remove();
        }
    }

}
