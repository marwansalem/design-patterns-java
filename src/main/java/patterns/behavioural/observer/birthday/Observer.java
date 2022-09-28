package patterns.behavioural.observer.birthday;

public interface Observer<T> {
    void handle(PropertyChangedEventArgs<T> args);
}
