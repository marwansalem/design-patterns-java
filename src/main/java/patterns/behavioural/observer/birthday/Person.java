package patterns.behavioural.observer.birthday;

public class Person extends Observable<Person> {
    private int age;
    private String name;

    public String getName() {
        return name;
    }

    public Person(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
        propertyChanged(this, "age", age);
    }
}
