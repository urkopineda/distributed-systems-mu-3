module ice_storm_chat_utils {
    struct Message {
        int id;
        string message;
    };

    interface ChatManager {
        void sendMessage(Message m);
    };
};
