package data;

import utils.ClientPrx;

/**
 * Created by urko on 15/03/16.
 */
public class User {

    private ClientPrx proxy;
    private String username;

    public User(ClientPrx proxy, String username) {
        this.proxy = proxy;
        this.username = username;
    }

    public ClientPrx getProxy() {
        return proxy;
    }

    public String getUsername() {
        return username;
    }

}
