package patterns.behavioural.state.lock;

class InputState extends LockState {
    public InputState(CombinationLock lk) {
        super(lk);
    }

    @Override
    public LockState getNext(int digit) {
        lock.status += "" + digit;

        if (lock.checkInputComplete()) {

            if (lock.checkCombinationMatches()) {
                return new Open(this.lock);
            } else {
                return new ErrorState(this.lock);
            }
        }
        return this;
    }
}
