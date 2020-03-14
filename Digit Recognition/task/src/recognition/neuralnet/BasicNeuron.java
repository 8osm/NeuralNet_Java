package recognition.neuralnet;

public class BasicNeuron {
    double valueStored = 0;
    NeuralNet neuralNet;
    public void fire(){};
    public BasicNeuron(NeuralNet neuralNet){
        this.neuralNet = neuralNet;
    }
}
