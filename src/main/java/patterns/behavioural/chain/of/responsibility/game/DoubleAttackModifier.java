package patterns.behavioural.chain.of.responsibility.game;

public class DoubleAttackModifier extends CreatureModifier {
    public DoubleAttackModifier(Creature creature) {
        super(creature);
    }

    @Override
    public void handle() {
        creature.setAttack(creature.getAttack() * 2);
        System.out.println("Doubling " + creature.getName() + "'s attack");
        super.handle();
    }
}
