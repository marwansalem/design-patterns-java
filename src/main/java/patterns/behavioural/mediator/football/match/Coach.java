package patterns.behavioural.mediator.football.match;

import patterns.behavioural.mediator.football.broker.GoalEventBroker;

public class Coach {
    public Coach(GoalEventBroker broker) {
         broker.subscribe(goals -> {
             System.out.println("Hey, you scored " + goals + " goals!");
         });
    }
}
