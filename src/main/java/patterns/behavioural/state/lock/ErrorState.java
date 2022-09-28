package patterns.behavioural.state.lock;

class ErrorState extends LockState {
    public ErrorState(CombinationLock lk) {
        super(lk);
        lock.status = "ERROR";
    }
}
