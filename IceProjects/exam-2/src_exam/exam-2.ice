module distributedSynchronization {
    interface Arbiter {
        bool take();
        void give();
    };
};