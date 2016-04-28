module chat {
    struct Contribution {
        string content;
    };
    interface ChatListener {
        void report (Contribution c);
    };
};