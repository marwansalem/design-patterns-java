package patterns.behavioural.state.classic;

public class State {

    void on(LightSwitch ls) {
        // on is not overriden in OnState
        // so calling Onstate.on will call the super
        System.out.println("Light is already on.");

    }
    void off(LightSwitch ls) {
        // off is not overriden in OffState
        // so calling OffState.off will call the super
        System.out.println("Light is already off.");
    }
}
