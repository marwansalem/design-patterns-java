package patterns.behavioural.state.lock;

class Locked extends LockState {
    public Locked(CombinationLock lk) {
        super(lk);
        lock.status = "LOCKED";
    }

    @Override
    public LockState getNext(int digit) {
        InputState state = new InputState(this.lock);
        this.lock.status = "";
        return state.getNext(digit);
    }
}
