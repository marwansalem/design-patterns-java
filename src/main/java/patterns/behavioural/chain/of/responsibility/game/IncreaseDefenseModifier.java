package patterns.behavioural.chain.of.responsibility.game;

public class IncreaseDefenseModifier extends CreatureModifier {
    public IncreaseDefenseModifier(Creature creature) {
        super(creature);
    }

    @Override
    public void handle() {
        System.out.println("Increasing " + creature.getName() + "'s defense");
        creature.setDefense(creature.getDefense() + 3);
        super.handle();
    }
}
