package patterns.structural.composite.bad.neural.network;

import java.util.ArrayList;
import java.util.List;

public class BadNeuron {
    private List<BadNeuron> in = new ArrayList<>();
    private List<BadNeuron> out = new ArrayList<>();

    public List<BadNeuron> getIn() {
        return in;
    }

    public void setIn(List<BadNeuron> in) {
        this.in = in;
    }

    public List<BadNeuron> getOut() {
        return out;
    }

    public void setOut(List<BadNeuron> out) {
        this.out = out;
    }


    public void connectTo(BadNeuron other) {
        out.add(other);
        other.getIn().add(this);
    }
}
