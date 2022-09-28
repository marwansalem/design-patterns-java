package patterns.behavioural.state.classic;

public class Demo {
    public static void main(String[] args) {
        LightSwitch lightSwitch = new LightSwitch();
        lightSwitch.off();
        lightSwitch.on();
        lightSwitch.off();
        lightSwitch.off();
        lightSwitch.on();
        lightSwitch.on();
    }
}
