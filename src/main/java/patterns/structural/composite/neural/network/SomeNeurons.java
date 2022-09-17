package patterns.structural.composite.neural.network;

public interface SomeNeurons extends Iterable<Neuron> {
    default void connectTo(SomeNeurons other) {
        if (this == other) {
            return;
        }
        for (Neuron from : this) {
            for (Neuron to : other) {
                from.getOut().add(to);
                to.getIn().add(from);
            }
        }
    }
}
