package patterns.structural.proxy.property;

public class Creature {
    // limit access to field by using a property proxy
    private Property<Integer> agility = new Property<>(10);

    public Creature() {
    }

    public void setAgility(int value) {
        agility.setValue(value);
    }

    public int getAgility() {
        return agility.getValue();
    }

    public static void main(String[] args) {
        Creature creature = new Creature();
        creature.setAgility(12);
    }

}
