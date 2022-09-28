package patterns.behavioural.state.lock;

class LockState {
    protected CombinationLock lock;

    public LockState(CombinationLock lock) {
        this.lock = lock;
    }

    public LockState getNext(int digit) {
        return this;
    }
}
