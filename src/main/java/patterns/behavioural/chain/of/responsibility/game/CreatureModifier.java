package patterns.behavioural.chain.of.responsibility.game;

public class CreatureModifier {
    protected Creature creature;
    protected CreatureModifier next;

    public CreatureModifier(Creature creature) {
        this.creature = creature;
    }
    public void add(CreatureModifier cm) {
        if (next != null) {
            // recursive
            next.add(cm);
        } else {
            next = cm;
        }
    }

    public void handle() {
        if (next != null) {
            next.handle();
        }
    }
}
