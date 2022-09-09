package patterns.creational.factory.drink;

public class Coffee implements HotDrink {
    @Override
    public void consume() {
        System.out.println("This coffee is too hot");
    }

    public static class Factory implements HotDrinkFactory {
        @Override
        public HotDrink prepare(int amount) {
            System.out.println("Grind some beans, boil water, pour "
                + amount + "ml, add cream and sugar, enjoy");
            return new Coffee();
        }
    }
}
