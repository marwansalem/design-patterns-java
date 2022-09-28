package patterns.behavioural.state.phone;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class PhoneSimulator {
    private static Map<State, Map<Trigger, State>> transition = new HashMap<>();
    static {
        transition.put(
            State.OFF_HOOK,
            Map.of(
                Trigger.CALL_DIALED, State.CONNECTED,
                Trigger.STOP_USING_PHONE, State.ON_HOOK
                )
        );

        transition.put(
            State.CONNECTING,
            Map.of(
                Trigger.HUNG_UP, State.OFF_HOOK,
                Trigger.CALL_CONNECTED, State.CONNECTED
                )
        );

        transition.put(
            State.CONNECTED,
            Map.of(
                Trigger.LEFT_MESSAGE, State.OFF_HOOK,
                Trigger.HUNG_UP, State.OFF_HOOK,
                Trigger.PLACED_ON_HOLD, State.ON_HOLD
            )
        );

        transition.put(
            State.ON_HOLD,
            Map.of(
                Trigger.TAKEN_OFF_HOLD, State.CONNECTED,
                Trigger.HUNG_UP, State.OFF_HOOK
            )
        );
    }

    private static State currentState = State.OFF_HOOK;
    private static State exitState = State.ON_HOOK;

    public static void main(String[] args) {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        while (currentState != exitState) {
            System.out.println("This phone is currently " + currentState);
            System.out.println("Input trigger");

            Set<Trigger> actions = transition.get(currentState).keySet();
            List<Trigger> possibleTriggers = actions.stream().collect(Collectors.toList());
            for (int i = 0; i < possibleTriggers.size(); i++) {
                Trigger t = possibleTriggers.get(i);
                System.out.println("" + i + ". " + t);
            }

            boolean parseOk;
            int choice = 0;
            do {
                try {
                    choice = Integer.parseInt(console.readLine());
                    parseOk = choice >= 0 && choice < possibleTriggers.size();
                } catch (Exception e) {
                    parseOk = false;
                }
            } while (!parseOk);
            Trigger currentTrigger = possibleTriggers.get(choice);

            currentState = transition.get(currentState).get(currentTrigger);
        }

        System.out.println("Call ended");
    }
}
