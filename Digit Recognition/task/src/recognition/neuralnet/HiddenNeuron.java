package recognition.neuralnet;

import recognition.connections.BasicNeuralConnection;

import java.util.ArrayList;

public class HiddenNeuron extends BasicNeuron {
        public ArrayList<BasicNeuralConnection> neuralConnections = new ArrayList<>(){};

    public HiddenNeuron(NeuralNet neuralNet) {
        super(neuralNet);
    }

    @Override
        public void fire(){
            for (BasicNeuralConnection neuralConnection: neuralConnections){
                neuralConnection.neuronConnectedTo.valueStored += this.valueStored*neuralConnection.weight;
            }
        }
}
