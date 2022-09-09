package patterns.creational.singleton.multiton;

import java.util.HashMap;
import java.util.Map;

public class Printer {
    public enum Subsystem {
        PRIMARY,
        AUXILLARY,
        FALLBACK
    }
    private static int instanceCount = 0;
    private static Map<Subsystem, Printer> instances = new HashMap<>();
    private Printer() {
        instanceCount++;
        System.out.println("A total of " + instanceCount + " printers created so far.");
    }

    public static Printer get(Subsystem ss) {
        if (instances.containsKey(ss)) {
            return instances.get(ss);
        }

        Printer instance = new Printer();
        instances.put(ss, instance);
        return instance;
    }

    public static void main(String[] args) {
        Printer primaryPrinter = Printer.get(Subsystem.PRIMARY);
        Printer auxPrinter = Printer.get(Subsystem.AUXILLARY);
        Printer auxPrinter2 = Printer.get(Subsystem.AUXILLARY);
        System.out.println(auxPrinter == auxPrinter2);
    }
}
