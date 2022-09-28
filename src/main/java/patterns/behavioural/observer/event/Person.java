package patterns.behavioural.observer.event;

public class Person {

    public Event<PropertyChangedEventArgs> propertyChanged = new Event<>();
    private String name;
    private int age;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        if (this.age == age) return;
        this.age = age;
        propertyChanged.fire(new PropertyChangedEventArgs(this, "age", age));
    }

    public int getAge() {
        return age;
    }
}
