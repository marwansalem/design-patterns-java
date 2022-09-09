package patterns.creational.factory.drink;

public class Tea implements HotDrink {
    @Override
    public void consume() {
        System.out.println("This tea is delicious!");
    }
    public static class Factory implements HotDrinkFactory {

        @Override
        public HotDrink prepare(int amount) {
            System.out.println("Put tea in bag, boil water "
                + amount + "ml, add lemon, enjoy!");
            return new Tea();
        }
    }
}
