package patterns.behavioural.chain.of.responsibility.game;

public class NoBonusModifer extends CreatureModifier {
    public NoBonusModifer(Creature creature) {
        super(creature);
    }

    @Override
    public void handle() {
        System.out.println("No more bonuses for you");
    }
}
