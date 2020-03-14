package recognition.connections;

import recognition.neuralnet.BasicNeuron;

public class BasicNeuralConnection {
    public BasicNeuron neuronConnectedTo;
    public double weight = 1;
    public BasicNeuralConnection(BasicNeuron neuronConnectedTo){
        this.neuronConnectedTo = neuronConnectedTo;
    }
}
