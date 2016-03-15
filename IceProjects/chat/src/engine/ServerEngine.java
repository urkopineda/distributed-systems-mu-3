package engine;

import chat.ChatManager;

/**
 * Chat engine used by the server.
 *
 * @author urko
 */
public class ServerEngine {

    private int port;

    private final String identity = "ChatRoom";

    private Ice.Communicator ic;
    private Ice.ObjectAdapter adapter;

    public ServerEngine(int port) {
        this.port = port;
    }

    public void start() {
        ic = Ice.Util.initialize();
        adapter = ic.createObjectAdapterWithEndpoints("", "tcp -p " + port);
        adapter.add(new ChatManager(), ic.stringToIdentity(identity));
        adapter.activate();
    }

    public void close() {
        ic.destroy();
    }

}
