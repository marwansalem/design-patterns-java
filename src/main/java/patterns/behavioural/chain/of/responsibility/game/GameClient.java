package patterns.behavioural.chain.of.responsibility.game;

public class GameClient {
    public static void main(String[] args) {
        Creature goblin = new Creature("Goblin", 2, 2);
        System.out.println(goblin);

        // create root handler as a starting to point
        CreatureModifier root = new CreatureModifier(goblin);
        // link rest of the chain to root

        System.out.println("Let's double goblin's attack");

        root.add(new DoubleAttackModifier(goblin));
        System.out.println("Let's double goblin's defense");

        root.add(new IncreaseDefenseModifier(goblin));

        root.add(new NoBonusModifer(goblin));
        // next one will not be applied
        root.add(new DoubleAttackModifier(goblin));
        root.handle();
        System.out.println(goblin);
    }
}
