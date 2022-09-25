package patterns.behavioural.chain.of.responsibility.cqs.modifiers;

import patterns.behavioural.chain.of.responsibility.cqs.Creature;
import patterns.behavioural.chain.of.responsibility.cqs.Query;
import patterns.behavioural.chain.of.responsibility.cqs.mediator.Game;

public class IncreaseDefenseModifier extends CreatureModifier {
    private final int token;
    public IncreaseDefenseModifier(Game game,
        Creature creature) {
        super(game, creature);
        token = game.queries.subscribe(q -> {
            if (q.creatureName.equals(creature.getName()) && q.argument == Query.Argument.DEFENSE) {
                q.result += 3;
            }
        });
    }
}
