package patterns.creational.singleton.enumbased;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public enum EnumBasedSingleton {
    INSTANCE;

    private int value;

    EnumBasedSingleton() {
        value = 42;
    }

    EnumBasedSingleton(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public EnumBasedSingleton setValue(int value) {
        this.value = value;
        return this;
    }
    static class Demo {
        static void saveToFile(EnumBasedSingleton singleton, String filename) throws Exception {
            try(FileOutputStream fileOut = new FileOutputStream(filename);
                ObjectOutputStream out = new ObjectOutputStream(fileOut)
            ) {
                out.writeObject(singleton);
            }
        }

        static EnumBasedSingleton readFromFile(String filename) throws Exception {
            try(FileInputStream fileIn = new FileInputStream(filename);
                ObjectInputStream in = new ObjectInputStream(fileIn)
            ) {
                return (EnumBasedSingleton) in.readObject();
            }
        }
    }

    public static void main(String[] args) throws Exception {
        String fileName = "enum-based.txt";
        EnumBasedSingleton singleton = EnumBasedSingleton.INSTANCE;
        singleton.setValue(311);
//        Demo.saveToFile(singleton, fileName);
        EnumBasedSingleton singleton2 = Demo.readFromFile(fileName);
        System.out.println(singleton2.getValue());
    }
}
