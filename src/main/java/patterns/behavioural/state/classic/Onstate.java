package patterns.behavioural.state.classic;

public class Onstate extends State {
    public Onstate() {
        System.out.println("Light turned on");
    }

    @Override
    void off(LightSwitch ls) {
        System.out.println("Switching light off");
        ls.setState(new OffState());
    }
}
