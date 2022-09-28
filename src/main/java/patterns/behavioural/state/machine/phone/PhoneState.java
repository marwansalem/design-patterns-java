package patterns.behavioural.state.machine.phone;

public enum PhoneState {
    OFF_HOOK, // starting to make a phone call
    ON_HOOK, // phone call done
    CONNECTING,
    CONNECTED,
    ON_HOLD
}