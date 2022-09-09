package patterns.creational.factory.drink;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.reflections.Reflections;

import util.Pair;

public class HotDrinkMachine {
    private List<Pair<String, HotDrinkFactory>> namedFactories = new ArrayList<>();
    public HotDrinkMachine() throws Exception {
        Set<Class<? extends HotDrinkFactory>> types = new Reflections("")
            .getSubTypesOf(HotDrinkFactory.class);
        for (Class<? extends  HotDrinkFactory> type: types) {
            String drinkName = type.getCanonicalName();
            drinkName = drinkName.replace(".Factory", "");
            drinkName = drinkName.substring(1 + drinkName.lastIndexOf("."));
            namedFactories.add(new Pair<>(
                drinkName,
                type.getDeclaredConstructor().newInstance()
            ));
        }


    }
    public HotDrink makeDrink() throws Exception {
        System.out.println("Available drinks:");
        for (int index = 0; index < namedFactories.size(); index++) {
            Pair<String, HotDrinkFactory> item = namedFactories.get(index);
            System.out.println("" + index + ": " + item.getFirst());
        }
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            String s;
            int i, amount;

            if ((s = reader.readLine()) != null
            && (i = Integer.parseInt(s)) >= 0
            && i < namedFactories.size()) {
                System.out.println("Specify amount:");
                s = reader.readLine();
                if (s != null && (amount = Integer.parseInt(s)) >= 0) {
                    return namedFactories.get(i).getSecond().prepare(amount);
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        HotDrinkMachine machine = new HotDrinkMachine();
        HotDrink drink = machine.makeDrink();
        drink.consume();
    }
}
