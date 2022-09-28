package patterns.behavioural.mediator.football.match;

import patterns.behavioural.mediator.football.broker.GoalEventBroker;

public class Match {
    public static void main(String[] args) {
        GoalEventBroker broker = new GoalEventBroker();
        FootballPlayer maradona = new FootballPlayer(broker, "Maradona", "Argentina National Team");
        Coach argentinaCoach = new Coach(broker);

        maradona.score();
        maradona.score();
        maradona.score();
    }
}
