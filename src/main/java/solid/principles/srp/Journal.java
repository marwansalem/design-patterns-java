package solid.principles.srp;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Journal {
    private final List<String> entries = new ArrayList<>();
    private static int count = 0;

    public void addEntry(String text) {
        entries.add("" + (++count) + ": " + text);
    }

    @Override
    public String toString() {
        return String.join(System.lineSeparator(), entries);
    }

    public static void main(String[] args) throws FileNotFoundException {
        Journal j = new Journal();
        j.addEntry("I woke up");
        j.addEntry("I had breakfast");
        System.out.println(j);

        Persistence p = new Persistence();
        p.saveToFile(j, "journal.txt", true);
    }
}
