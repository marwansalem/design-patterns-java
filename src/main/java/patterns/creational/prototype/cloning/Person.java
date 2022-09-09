package patterns.creational.prototype.cloning;

import java.util.Arrays;

public class Person implements Cloneable{
    public String []names;
    public Address address;

    public Person(String[] names, Address address) {
        this.names = names;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person{" +
            "names=" + Arrays.toString(names) +
            ", address=" + address +
            '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return new Person(
            names.clone(),
            (Address) address.clone()
        );
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        Person john = new Person(new String[] { "John", "Smith" },
            new Address("London road", 123));

        System.out.println(john.clone());
    }
}
