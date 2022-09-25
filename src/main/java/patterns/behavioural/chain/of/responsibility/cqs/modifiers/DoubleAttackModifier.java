package patterns.behavioural.chain.of.responsibility.cqs.modifiers;

import patterns.behavioural.chain.of.responsibility.cqs.Creature;
import patterns.behavioural.chain.of.responsibility.cqs.Query;
import patterns.behavioural.chain.of.responsibility.cqs.mediator.Game;

public class DoubleAttackModifier extends CreatureModifier implements AutoCloseable {
    private final int token;
    public DoubleAttackModifier(Game game,
        Creature creature) {
        super(game, creature);
        // subscribe to any queries that query the attack value
        token = game.queries.subscribe(q -> {
            if (q.creatureName.equals(creature.getName()) && q.argument == Query.Argument.ATTACK) {
                q.result *= 2;
            }
        });
    }

    @Override
    public void close() {
        game.queries.unsubscribe(token);
    }
}
