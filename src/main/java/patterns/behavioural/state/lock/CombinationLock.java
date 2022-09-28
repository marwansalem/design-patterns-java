package patterns.behavioural.state.lock;

public class CombinationLock {
    private int[] combination;
    public String status = "";
    private LockState lockState = new Locked(this);

    public CombinationLock(int[] combination) {
        this.combination = combination;
    }

    public void enterDigit(int digit) {
        this.lockState = lockState.getNext(digit);
    }

    public boolean checkInputComplete() {
        return status.length() == combination.length;
    }

    public boolean checkCombinationMatches() {
        String combinationCode = "";
        for (int i : combination) {
            combinationCode += "" + i;
        }
        return combinationCode.equals(status);
    }

}
