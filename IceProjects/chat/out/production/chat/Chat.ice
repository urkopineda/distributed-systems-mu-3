module utils
{
    interface Client
    {
        void read(string message);
    };

    interface ChatManager
    {
        int subscribe(string name, Client* client);
        void unsubscribe(int id);
        void write(int id, string message);
    };
};