package recognition.connections;

import recognition.neuralnet.BasicNeuron;

public class BasicNeuralConnection {
    public BasicNeuron neuronConnectedTo;
    public double weight;
    public BasicNeuralConnection(BasicNeuron neuronConnectedTo, double weight){
        this.neuronConnectedTo = neuronConnectedTo;
        this.weight = weight;
    }
}
