package patterns.behavioural.chain.of.responsibility.cqs.mediator;

import patterns.behavioural.chain.of.responsibility.cqs.Creature;
import patterns.behavioural.chain.of.responsibility.cqs.Event;
import patterns.behavioural.chain.of.responsibility.cqs.Query;
import patterns.behavioural.chain.of.responsibility.cqs.modifiers.DoubleAttackModifier;
import patterns.behavioural.chain.of.responsibility.cqs.modifiers.IncreaseDefenseModifier;

// Game acts as the event broker
public class Game {
    public Event<Query> queries = new Event<>();

    public static void main(String[] args) {
        Game game = new Game();
        Creature goblin = new Creature(game, "Strong Goblin", 2, 2);
        System.out.println(goblin);
        IncreaseDefenseModifier icm = new IncreaseDefenseModifier(game, goblin);
        DoubleAttackModifier dam = new DoubleAttackModifier(game, goblin);
        try (dam) {
            System.out.println(goblin);
            // here Double Attack modifier will be applied
        }
        // after try-with-resources, dam will have no effect
        System.out.println(goblin);
    }
}
