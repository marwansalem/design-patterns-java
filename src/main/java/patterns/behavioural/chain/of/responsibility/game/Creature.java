package patterns.behavioural.chain.of.responsibility.game;

public class Creature {
    private String name;
    private int attack;
    private int defense;

    public Creature(String name, int attack, int defense) {
        this.name = name;
        this.attack = attack;
        this.defense = defense;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    @Override
    public String toString() {
        return "Creature{" +
            "name='" + name + '\'' +
            ", attack=" + attack +
            ", defense=" + defense +
            '}';
    }
}
