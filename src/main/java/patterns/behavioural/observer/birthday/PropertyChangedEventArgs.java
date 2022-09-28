package patterns.behavioural.observer.birthday;

public class PropertyChangedEventArgs<T> {
    private T source;
    private String propertyName;
    private Object newValue;

    public T getSource() {
        return source;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public Object getNewValue() {
        return newValue;
    }

    public PropertyChangedEventArgs(T source, String propertyName, Object newValue) {
        this.source = source;
        this.propertyName = propertyName;
        this.newValue = newValue;
    }
}
