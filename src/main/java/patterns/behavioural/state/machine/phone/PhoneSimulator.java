package patterns.behavioural.state.machine.phone;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.EnumSet;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.config.StateMachineBuilder;
import org.springframework.statemachine.state.State;
import org.springframework.statemachine.transition.Transition;

import patterns.behavioural.observer.event.Event;

public class PhoneSimulator {
    public static StateMachine<PhoneState, Events> buildMachine() throws Exception {
        StateMachineBuilder.Builder<PhoneState, Events> builder = StateMachineBuilder.builder();
        builder.configureStates()
            .withStates()
                .initial(PhoneState.OFF_HOOK)
                .states(EnumSet.allOf(PhoneState.class));

        builder.configureTransitions()
            .withExternal()
                .source(PhoneState.OFF_HOOK)
                .event(Events.CALL_DIALED)
                .target(PhoneState.CONNECTING)
            .and()
            .withExternal()
                .source(PhoneState.OFF_HOOK)
                .event(Events.STOP_USING_PHONE)
                .target(PhoneState.ON_HOOK)
            .and()
            .withExternal()
                .source(PhoneState.CONNECTING)
                .event(Events.HUNG_UP)
                .target(PhoneState.OFF_HOOK)
            .and()
            .withExternal()
                .source(PhoneState.CONNECTING)
                .event(Events.CALL_CONNECTED)
                .target(PhoneState.CONNECTED)
            .and()
            .withExternal()
                .source(PhoneState.CONNECTED)
                .event(Events.LEFT_MESSAGE)
                .target(PhoneState.OFF_HOOK)
            .and()
            .withExternal()
                .source(PhoneState.CONNECTED)
                .event(Events.HUNG_UP)
                .target(PhoneState.OFF_HOOK)
            .and()
            .withExternal()
                .source(PhoneState.CONNECTED)
                .event(Events.PLACED_ON_HOLD)
                .target(PhoneState.ON_HOLD)
            .and()
            .withExternal()
                .source(PhoneState.ON_HOLD)
                .event(Events.TAKEN_OFF_HOLD)
                .target(PhoneState.CONNECTED)
            .and()
            .withExternal()
                .source(PhoneState.ON_HOLD)
                .event(Events.HUNG_UP)
                .target(PhoneState.OFF_HOOK);

        return builder.build();
    }

    public static int chooseTrigger(List<Transition<PhoneState, Events>> ts, BufferedReader console) {
        for (int i = 0; i < ts.size(); i++) {
            System.out.println("" + i +". " + ts.get(i).getTrigger().getEvent());

        }

        boolean parseOk;
        int choice = 0;
        do {
            try {
                System.out.println("Please enter your choice");
                choice = Integer.parseInt(console.readLine());
                parseOk = choice >= 0 & choice < ts.size();
            } catch (Exception e) {
                parseOk = false;
            }
        } while (!parseOk);

        return choice;
    }

    public static void main(String[] args) throws Exception {
        StateMachine<PhoneState, Events> machine = buildMachine();
        machine.start();

        PhoneState exitState = PhoneState.ON_HOOK;
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            State<PhoneState, Events> state = machine.getState();
            System.out.println("The phone is currently " + state.getId());
            System.out.println("Selecting trigger");
            List<Transition<PhoneState, Events>> ts = machine.getTransitions()
                .stream()
                .filter(t -> t.getSource() == state)
                .collect(Collectors.toList());

            int choice = chooseTrigger(ts, console);
            machine.sendEvent(ts.get(choice).getTrigger().getEvent());

            if (machine.getState().getId() == exitState) {
                break;
            }
        }
    }

}
