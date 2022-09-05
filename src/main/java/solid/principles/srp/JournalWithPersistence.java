package solid.principles.srp;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class JournalWithPersistence {
    private final List<String> entries = new ArrayList<>();
    private static int count = 0;

    public void addEntry(String text) {
        entries.add("" + (++count) + ": " + text);
    }

    @Override
    public String toString() {
        return String.join(System.lineSeparator(), entries);
    }


    // other concerns should not be in this class
    public void save(String filename) throws FileNotFoundException {
        try (PrintStream out = new PrintStream(filename)) {
            out.println(toString());
        }
    }
    public void load(String filename) {}
    public void load(URL url) {}

    public static void main(String[] args) {
        JournalWithPersistence j = new JournalWithPersistence();
        j.addEntry("I woke up");
        j.addEntry("I had breakfast");
        System.out.println(j);
    }
}
