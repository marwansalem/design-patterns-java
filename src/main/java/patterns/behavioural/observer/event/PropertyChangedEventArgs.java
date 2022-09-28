package patterns.behavioural.observer.event;

public class PropertyChangedEventArgs {
    private Object source;
    private String propertyName;
    private Object newValue;

    public PropertyChangedEventArgs(Object source, String propertyName, Object newValue) {
        this.source = source;
        this.propertyName = propertyName;
        this.newValue = newValue;
    }

    public Object getSource() {
        return source;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public Object getNewValue() {
        return newValue;
    }
}
