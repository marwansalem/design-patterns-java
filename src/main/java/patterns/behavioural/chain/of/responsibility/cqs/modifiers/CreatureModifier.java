package patterns.behavioural.chain.of.responsibility.cqs.modifiers;

import patterns.behavioural.chain.of.responsibility.cqs.Creature;
import patterns.behavioural.chain.of.responsibility.cqs.mediator.Game;

public class CreatureModifier {
    protected Game game;
    protected Creature creature;

    public CreatureModifier(Game game, Creature creature) {
        this.game = game;
        this.creature = creature;
    }
}
