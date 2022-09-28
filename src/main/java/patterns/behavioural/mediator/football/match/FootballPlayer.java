package patterns.behavioural.mediator.football.match;

import patterns.behavioural.mediator.football.broker.GoalEventBroker;

public class FootballPlayer {
    private int goalsScored = 0;
    private GoalEventBroker broker;
    private String name;
    private String team;

    public FootballPlayer(GoalEventBroker broker, String name, String team) {
        this.broker = broker;
        this.name = name;
        this.team = team;
    }

    public int getGoalsScored() {
        return goalsScored;
    }

    public String getName() {
        return name;
    }

    public String getTeam() {
        return team;
    }

    public void score() {
        broker.publish(++goalsScored);
    }
}
