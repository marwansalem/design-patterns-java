package patterns.creational.singleton.serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class BasicSingleton implements Serializable {
    private final static BasicSingleton INSTANCE = new BasicSingleton();
    private int value;
    private BasicSingleton() {}

    public int getValue() {
        return value;
    }

    public BasicSingleton setValue(int value) {
        this.value = value;
        return this;
    }
    public static BasicSingleton readFromFile(String filename) throws Exception {
        try (FileInputStream fileIn = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(fileIn)
        ) {
            return (BasicSingleton) in.readObject();
        }
    }

    public static void writeToFile(BasicSingleton singleton, String filename) throws Exception {
        try (FileOutputStream fileOut = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(fileOut)
        ) {
            out.writeObject(singleton);
        }
    }

    public static BasicSingleton getInstance() {
        return INSTANCE;
    }

    // add this to make sure that instances are serialized into the singleton instance
    protected Object readResolve() {
        return INSTANCE;
    }
    public static void main(String[] args) throws Exception {
        BasicSingleton instance = getInstance();
        instance.setValue(100);
        writeToFile(instance, "yes.txt");
        instance.setValue(200);
        BasicSingleton basicSingleton = readFromFile("yes.txt");
        System.out.println(basicSingleton == instance);
        System.out.println(basicSingleton.getValue());
        System.out.println(instance.getValue());

    }
}
