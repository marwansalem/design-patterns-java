package patterns.structural.composite.bad.neural.network;

public class Client {
    public static void main(String[] args) {
        BadNeuron neuron = new BadNeuron();
        BadNeuron neuron2 = new BadNeuron();
        BadNeuronLayer layer = new BadNeuronLayer();
        BadNeuronLayer layer2 = new BadNeuronLayer();

        // I can do this
        neuron.connectTo(neuron2);

        // But I cannot easily do this
        // neuron.connectTo(layer);
        // layer.connectTo(neuron);
        // layer.connectTo(neuron);
        // layer.connectTo(layer2);

    }
}
