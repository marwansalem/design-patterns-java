package patterns.structural.proxy.property;

import java.util.Objects;

public class Property<T> {
    private T value;

    public Property(T value) {
        this.value = value;
    }

    public T getValue() {
        System.out.println("Accessing property " + value);

        return value;
    }

    public void setValue(T value) {
        // logging here
        System.out.println("Setting value to " + value);
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Property<?> property = (Property<?>) o;
        return Objects.equals(value, property.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
