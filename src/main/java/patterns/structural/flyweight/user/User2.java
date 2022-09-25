package patterns.structural.flyweight.user;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class User2 {
    static List<String> strings = new ArrayList<>();
    private int[] names;
    public User2(String fullName) {
        Function<String, Integer> getOrAdd = (String s) -> {
            int idx = strings.indexOf(s);
            if (idx != -1) {
                return idx;
            }

            strings.add(s);
            // index of last item;
            return strings.size() - 1;
         };
         names = Arrays.stream(fullName.split(" "))
            .mapToInt(getOrAdd::apply)
            .toArray();

    }

    public static void main(String[] args) {
        User2 john = new User2("John Smith");
        User2 jane = new User2("Jane Smith");
    }

}
