package patterns.behavioural.state.lock;

class Open extends LockState {
    public Open(CombinationLock lk) {
        super(lk);
        lock.status = "OPEN";
    }
}
