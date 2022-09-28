package patterns.behavioural.observer.event;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class Event<TArgs> {
    Map<Subscription, Consumer<TArgs>> handlers = new HashMap<>();
    public Subscription addHandler(Consumer<TArgs> handler) {
        Subscription subscription = new Subscription(this);
        handlers.put(subscription, handler);
        return subscription;
    }

    public void fire(TArgs args) {
        for (Consumer<TArgs> handler : handlers.values()) {
            handler.accept(args);
        }
    }
    public class Subscription implements AutoCloseable {
        private Event<TArgs> event;

        public Subscription(Event<TArgs> event) {
            this.event = event;
        }

        @Override
        public void close() throws Exception {
            event.handlers.remove(this);
        }
    }
}
