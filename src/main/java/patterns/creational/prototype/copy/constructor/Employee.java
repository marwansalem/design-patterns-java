package patterns.creational.prototype.copy.constructor;

public class Employee {
    public String name;
    public Address address;

    @Override
    public String toString() {
        return "Employee{" +
            "name='" + name + '\'' +
            ", address=" + address +
            '}';
    }

    public Employee(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    public Employee(Employee other) {
        name = other.name;
        address = new Address(other.address);
    }

    public static void main(String[] args) {
        Employee john = new Employee("John",
            new Address("123 London Road", "London", "UK"));

        Employee chris = new Employee(john);

        chris.name = "Chris";
        System.out.println(john);
        System.out.println(chris);
    }
}
