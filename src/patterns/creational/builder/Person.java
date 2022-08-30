package patterns.creational.builder;

public class Person {
    String name;
    String position;

    @Override
    public String toString() {
        return "Person{" +
            "name='" + name + '\'' +
            ", position='" + position + '\'' +
            '}';
    }

    public static class PersonBuilder<SELF extends PersonBuilder<SELF>> {
        protected Person person = new Person();
        public SELF withName(String name) {
            person.name = name;
            return self();
        }

        protected SELF self() {
            return (SELF) this;
        }
        public Person build() {
            return person;
        }
    }

    public static class EmployeeBuilder extends PersonBuilder<EmployeeBuilder> {
        @Override
        protected EmployeeBuilder self() {
            return this;
        }

        public EmployeeBuilder worksAt(String position) {
            person.position = position;
            return self();
        }
    }

    public static void main(String[] args) {
        EmployeeBuilder eb = new EmployeeBuilder();
        Person p = eb.withName("Joe")
            .worksAt("Company")
            .build();
        System.out.println(p);
    }
}
