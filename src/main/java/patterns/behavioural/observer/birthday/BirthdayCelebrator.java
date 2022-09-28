package patterns.behavioural.observer.birthday;

public class BirthdayCelebrator implements Observer<Person>{
    @Override
    public void handle(PropertyChangedEventArgs<Person> args) {
        int age = (int) args.getNewValue();
        System.out.println("Happy birthday! " + args.getSource().getName() + " turned " + age);
    }

    public BirthdayCelebrator() {
    }

    public static void main(String[] args) {
        BirthdayCelebrator monitor = new BirthdayCelebrator();
        Person ali = new Person("Ali");
        Person mona = new Person("Mona");
        ali.subscribe(monitor);
        mona.subscribe(monitor);

        ali.setAge(0);
        mona.setAge(15);
        ali.setAge(10);
        ali.setAge(20);
        mona.setAge(30);

    }
}
