package recognition.neuralnet;

public class OutputNeuron extends BasicNeuron {
    public OutputNeuron(NeuralNet neuralNet) {
        super(neuralNet);
    }

    @Override
    public void fire(){
        this.neuralNet.outputValues.add(this.valueStored);
    }
}
