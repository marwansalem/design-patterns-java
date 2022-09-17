package patterns.structural.composite.neural.network;

import java.util.ArrayList;
import java.util.List;

public class NeuronLayer extends ArrayList<Neuron> implements SomeNeurons {
    // no need to implement anything
    // because ArrayList<Neuron> already implements Iterable<Neuron>
    private List<Neuron> in;
    private List<Neuron> out;

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
