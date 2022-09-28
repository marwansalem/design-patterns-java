package patterns.behavioural.state.classic;

public class LightSwitch {
    private State state;

    public LightSwitch() {
        state = new OffState();
    }

    public void on() {
        state.on(this);
    }

    public void off() {
        state.off(this);
    }

    void setState(State state) {
        this.state = state;
    }
}
