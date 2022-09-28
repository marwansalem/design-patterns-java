package patterns.behavioural.mediator.football.broker;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;

public class GoalEventBroker extends Observable<Integer> {
    private List<Observer<? super Integer>> observers = new ArrayList<>();
    @Override
    protected void subscribeActual(Observer<? super Integer> observer) {
        observers.add(observer);
    }

    public void publish(int n) {
        for (Observer<? super Integer> o : observers) {
            // publish to subscribers
            o.onNext(n);
        }
    }
}
