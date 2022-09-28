package patterns.behavioural.state.phone;

public enum State {
    OFF_HOOK, // starting to make a phone call
    ON_HOOK, // phone call done
    CONNECTING,
    CONNECTED,
    ON_HOLD
}