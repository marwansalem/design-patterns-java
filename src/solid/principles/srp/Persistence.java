package solid.principles.srp;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.net.URL;

public class Persistence {
    public void saveToFile(Journal journal, String filename, boolean overwrite) throws FileNotFoundException {
        if (overwrite || !new File(filename).exists()) {
            try (PrintStream out = new PrintStream(filename)) {
                out.println(journal.toString());
            }
        }
    }

    // no need to implement, this is just for examples
    public Journal load(String filename) { return null;}
    public Journal load(URL url) {return null;}

}
