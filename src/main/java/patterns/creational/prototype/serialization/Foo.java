package patterns.creational.prototype.serialization;

import java.io.Serializable;

import org.apache.commons.lang3.SerializationUtils;

public class Foo implements Serializable {
    // SerializationUtils requires implementing Serializable
    public int stuff;
    public String whatever;

    public Foo(int stuff, String whatever) {
        this.stuff = stuff;
        this.whatever = whatever;
    }

    @Override
    public String toString() {
        return "Foo{" +
            "stuff='" + stuff + '\'' +
            ", whatever='" + whatever + '\'' +
            '}';
    }

    public static void main(String[] args) {
        Foo foo1 = new Foo(365, "/2");

        Foo foo2 = (Foo) SerializationUtils.clone(foo1);
        System.out.println(foo1);
        System.out.println(foo2);
    }
}
