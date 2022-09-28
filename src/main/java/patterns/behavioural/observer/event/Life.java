package patterns.behavioural.observer.event;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;

public class Life {

    public static class Friend {
        protected String name;

        public Friend(String name) {
            this.name = name;
        }

        public Consumer<PropertyChangedEventArgs> getFriendBirthdayHandler() {
            return eventArgs -> {
                Person myFriend = (Person) eventArgs.getSource();
                System.out.println("Happy Birthday " + myFriend.getName() + ", you turned " + eventArgs.getNewValue() + " !");
            };
        }
    }

    public static class BestFriend extends Friend {
        public BestFriend(String name) {
            super(name);
        }

        @Override
        public Consumer<PropertyChangedEventArgs> getFriendBirthdayHandler() {
            return eventArgs -> {
                Person myBestoFriendo = (Person) eventArgs.getSource();
                System.out.println("HBD " + myBestoFriendo.getName() + ", I can't believe you are " + eventArgs.getNewValue() + "! Enjoy your gift! -" + name);
            };
        }
    }

    public static class Boss {
        public Consumer<PropertyChangedEventArgs> getEmployeeBirthdayHandler() {
            return eventArgs -> {
                Person emp = (Person) eventArgs.getSource();
                System.out.println("Happy Birthday Mr. " + emp.getName() + ", finish your work or no cake!");
            };
        }
    }

    public static class AgeChangeAnnouncer {
        public void announceBirthday(PropertyChangedEventArgs eventArgs) {
            Person person = (Person) eventArgs.getSource();
            Set<Integer> s= new HashSet<>();
            for (Integer integer : s) {
                
            }

            System.out.println(person.getName() + " has turned " + eventArgs.getNewValue());
        }
    }

    public static void main(String[] args) throws Exception {
        Person omar = new Person("Omar");
        AgeChangeAnnouncer announcer = new AgeChangeAnnouncer();

        omar.propertyChanged.addHandler(announcer::announceBirthday);

        Friend aFriendOfOmar = new Friend("Ali");
        omar.propertyChanged.addHandler(aFriendOfOmar.getFriendBirthdayHandler());

        BestFriend bestie = new BestFriend("Amr");
        omar.propertyChanged.addHandler(bestie.getFriendBirthdayHandler());
        omar.setAge(10);
        omar.setAge(15);
        omar.setAge(20);

        Boss boss = new Boss();
        try (Event<PropertyChangedEventArgs>.Subscription s = omar.propertyChanged.addHandler(boss.getEmployeeBirthdayHandler())) {
            omar.setAge(25);
            omar.setAge(40);
            omar.setAge(60);
        }
        // omar becomes the boss now

        omar.setAge(65);

    }
}
