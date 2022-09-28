package patterns.behavioural.mediator.chat.room;

import java.util.ArrayList;
import java.util.List;

public class ChatRoom {
    private List<Person> people = new ArrayList<>();

    public void join(Person p) {
        String joinMsg = p.getName() + " joins the room";
        broadcast("room", joinMsg);
        p.setChatRoom(this);
        people.add(p);
    }

    public void broadcast(String source, String message) {
        for (Person person : people) {
            if (!person.getName().equals("source")) {
                person.receive(source, message);
            }
        }
    }

    public void message(String source, String destination, String message) {
        people.stream()
            .filter(p -> p.getName().equals(destination))
            .findFirst()
            .ifPresent(p -> p.receive(source, message));
    }

    public static void main(String[] args) {
        ChatRoom room = new ChatRoom();
        Person jane = new Person("Jane");
        Person jo = new Person("Jo");
        room.join(jane);
        room.join(jo);

        jo.say("hi room");
        jane.say("hello jo!");

        Person simon = new Person("Simon");
        room.join(simon);

        simon.say("Good morning");
        jane.say("How much?");
        simon.say("inbox.");

        simon.privateMessage("Jane", "926");
    }
}
