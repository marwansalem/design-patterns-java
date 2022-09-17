package patterns.structural.composite.neural.network;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;

public class Neuron implements SomeNeurons {
    private List<Neuron> in = new ArrayList<>();
    private List<Neuron> out = new ArrayList<>();

    @Override
    public Iterator<Neuron> iterator() {
        return Collections.singleton(this).iterator();
    }

    @Override
    public void forEach(Consumer<? super Neuron> action) {
        action.accept(this);
    }

    @Override
    public Spliterator<Neuron> spliterator() {
        return Collections.singleton(this).spliterator();
    }


    public List<Neuron> getIn() {
        return in;
    }

    public void setIn(List<Neuron> in) {
        this.in = in;
    }

    public List<Neuron> getOut() {
        return out;
    }

    public void setOut(List<Neuron> out) {
        this.out = out;
    }
}
