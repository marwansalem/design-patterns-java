package patterns.behavioural.chain.of.responsibility.cqs;

import patterns.behavioural.chain.of.responsibility.cqs.mediator.Game;

public class Creature {
    private Game game;
    private String name;
    private int baseAttack;
    private int baseDefense;

    public String getName() {
        return name;
    }

    public Creature(Game game, String name, int baseAttack, int baseDefense) {
        this.game = game;
        this.name = name;
        this.baseAttack = baseAttack;
        this.baseDefense = baseDefense;
    }

    int getAttack() {
        Query q = new Query(name, Query.Argument.ATTACK, baseAttack);
        game.queries.fire(q);
        return q.getResult();
    }

    int getDefense() {
        Query q = new Query(name, Query.Argument.DEFENSE, baseDefense);
        game.queries.fire(q);
        return q.getResult();
    }

    @Override
    public String toString() {
        return "Creature{" +
            "name='" + name + '\'' +
            ", attack=" + getAttack() +
            ", defense=" + getDefense() +
            '}';
    }
}
