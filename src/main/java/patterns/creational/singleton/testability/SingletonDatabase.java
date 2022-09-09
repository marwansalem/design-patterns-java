package patterns.creational.singleton.testability;

import static org.junit.Assert.assertEquals;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;

import org.junit.Test;

import com.google.common.collect.Iterables;

public class SingletonDatabase implements Database {
    private Dictionary<String, Integer> capitals = new Hashtable<>();
    private static int instanceCount = 0;
    public static int getInstanceCount() {
        return instanceCount;
    }

    private SingletonDatabase() {
        instanceCount++;
        System.out.println("Initializing database");

        try {
            Path fullPath = Path.of( "src", "main", "resources", "singleton-database", "capitals.txt");
            List<String> lines = Files.readAllLines(fullPath);
            Iterables.partition(lines, 2)
                .forEach(kv -> capitals.put(
                    kv.get(0).trim(),
                    Integer.parseInt(kv.get(1))
                ));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static final SingletonDatabase INSTANCE = new SingletonDatabase();
    public static SingletonDatabase getInstance() {
        return INSTANCE;
    }

    public int getPopulation(String name) {
        return capitals.get(name);
    }
    static class SingletonRecorderFinder {
        public int getTotalPopulation(List<String> names) {
            int result = 0;
            for (String name: names) {
                result += SingletonDatabase.getInstance().getPopulation(name);
            }
            return result;
        }
    }
    static class ConfigurableRecordFinder {
        private Database database;
        public ConfigurableRecordFinder(Database database) {
            this.database = database;
        }

        public int getTotalPopulation(List<String> names) {
            int result = 0;
            for (String name: names) {
                result += database.getPopulation(name);
            }
            return result;
        }
    }

    public static class Tests {
        private static class DummyDatabase implements Database {
            private Dictionary<String, Integer> data = new Hashtable<>();

            public DummyDatabase() {
                data.put("alpha", 1);
                data.put("beta", 2);
                data.put("gamma", 3);
            }
            @Override
            public int getPopulation(String name) {
                return data.get(name);
            }
        }

        // running test against main database using Singleton
        @Test
        public void singletonTotalPopulationTest() {
            SingletonRecorderFinder rf = new SingletonRecorderFinder();
            List<String> names = List.of("Seoul", "Mexico City");

            int total = rf.getTotalPopulation(names);
            assertEquals(17500000 + 17400000, total);
        }

        @Test
        public void dummyDatabaseTotalPopulationTest() {
            Database database = new DummyDatabase();
            ConfigurableRecordFinder rf = new ConfigurableRecordFinder(database);

            List<String> names = List.of("alpha", "beta", "gamma");
            assertEquals(6, rf.getTotalPopulation(names));
        }
    }


    public static void main(String[] args) {
        Tests tests = new Tests();
        tests.singletonTotalPopulationTest();
        tests.dummyDatabaseTotalPopulationTest();
    }
}
