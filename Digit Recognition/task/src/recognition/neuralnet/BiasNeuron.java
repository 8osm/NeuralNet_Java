package recognition.neuralnet;

import recognition.connections.BasicNeuralConnection;

import java.util.ArrayList;

public class BiasNeuron extends BasicNeuron{
    ArrayList<BasicNeuralConnection> neuralConnections = new ArrayList<>(){};
    double bias;
    @Override
    public void fire() {
        for (BasicNeuralConnection neuralConnection: neuralConnections){
            neuralConnection.neuronConnectedTo.valueStored += this.bias;
        }
    }
    public BiasNeuron(double bias, NeuralNet neuralNet){
        super(neuralNet);
        this.bias = bias;
    }
}
