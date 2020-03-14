package recognition.neuralnet;

import org.jetbrains.annotations.NotNull;
import recognition.connections.BasicNeuralConnection;

import java.util.ArrayList;
import java.util.Random;

public class NeuralNet {
    int hiddenLayerCount; // TODO Replace the HiddenNeuron creation in the constructor with a dynamic one; This variable does nothing for now
    int outputCount;
    int inputCount;
    int hiddenCount;

    ArrayList<InputNeuron> inputNeurons = new ArrayList<>();
    ArrayList<OutputNeuron> outputNeurons = new ArrayList<>();
    ArrayList<ArrayList<HiddenNeuron>> hiddenNeurons = new ArrayList<>();
    ArrayList<BiasNeuron> biasNeurons = new ArrayList<>();

    public ArrayList<Double> outputValues = new ArrayList<>();

    public NeuralNet(int hiddenLayerCount, int inputCount, int outputCount, int hiddenCount){
        this.hiddenLayerCount = hiddenLayerCount;
        this.inputCount = inputCount;
        this.outputCount = outputCount;
        this.hiddenCount = hiddenCount;

        Random random = new Random();

        for (int i = 0; i < outputCount; i++) { //Create outputCount of OutputNeurons
            this.outputNeurons.add(new OutputNeuron(this));
        }

        hiddenNeurons.add(new ArrayList<>());
        for (int currentHiddenNeuron = 0; currentHiddenNeuron < hiddenCount; currentHiddenNeuron++) { //For every OutputNeurons, create as much connections as there are HiddenNeurons in that layer and immediately  + add the connections to the current HiddenNeuron
            HiddenNeuron tempNeuron = new HiddenNeuron(this);
            for(OutputNeuron outputNeuron: outputNeurons){
                tempNeuron.neuralConnections.add(new BasicNeuralConnection(outputNeuron,1));
//                tempNeuron.neuralConnections.add(new BasicNeuralConnection(outputNeuron,random.nextGaussian()));
            }
            hiddenNeurons.get(0).add(tempNeuron);
        }
//        for (int currentLayer = 1; currentLayer < layerCount; currentLayer++) { //Creating HiddenNeurons, starting from the ones before the ones before the output neurons
//            hiddenNeurons.add(new ArrayList<>());
//            for(HiddenNeuron hiddenNeuron: hiddenNeurons.get(currentLayer)){
//                tempNeuron.neuralConnections.add(new BasicNeuralConnection(outputNeuron));
//            }
//        }
        hiddenNeurons.add(new ArrayList<>());
        for (int currentHiddenNeuron = 0; currentHiddenNeuron < hiddenCount; currentHiddenNeuron++) { //For now, a static solution for only two layers TODO Replace with a dynamic solution
            HiddenNeuron tempNeuron = new HiddenNeuron(this);
            for(HiddenNeuron hiddenNeuron: hiddenNeurons.get(0)){
                tempNeuron.neuralConnections.add(new BasicNeuralConnection(hiddenNeuron,1));
//                tempNeuron.neuralConnections.add(new BasicNeuralConnection(hiddenNeuron, random.nextGaussian()));
            }
            hiddenNeurons.get(0).add(tempNeuron);
        }

        for (int currentInputNeuron = 0; currentInputNeuron < inputCount; currentInputNeuron++) { // Creating connection for the input layer
            InputNeuron tempNeuron = new InputNeuron(this);
            for(HiddenNeuron hiddenNeuron: hiddenNeurons.get(1)){ //TODO Replace with a dynamic solution
                tempNeuron.neuralConnections.add(new BasicNeuralConnection(hiddenNeuron,1));
//                tempNeuron.neuralConnections.add(new BasicNeuralConnection(hiddenNeuron,random.nextGaussian()));
            }
            inputNeurons.add(tempNeuron);
        }

        biasNeurons.add(new BiasNeuron(1, this)); //Creating BiasNeurons for the output layer TODO Find a way to combine the creation of BiasNeurons of the output layer with the one for the hidden layers
        for (OutputNeuron outputNeuron: outputNeurons){
            biasNeurons.get(0).neuralConnections.add(new BasicNeuralConnection(outputNeuron, 1));
        }

        for (int currentBiasedLayer = hiddenLayerCount; currentBiasedLayer > 1; currentBiasedLayer--) { //Create a BiasNeuron for every biased layer in the network (the input layer and the first hidden layer don't need a bias) TODO Replace or include into HiddenNeuron creation loop to comply with layerCount variable
            biasNeurons.add(new BiasNeuron(1, this));
            for (HiddenNeuron hiddenNeuron: hiddenNeurons.get(currentBiasedLayer)){
                biasNeurons.get(currentBiasedLayer).neuralConnections.add(new BasicNeuralConnection(hiddenNeuron, 1));
            }
        }
    }

    public ArrayList<Double> guess(@NotNull double[] inputValues){
        if(inputValues.length != inputCount) return null;
        for (int inputValue = 0; inputValue < inputValues.length; inputValue++) {
            inputNeurons.get(inputValue).valueStored = inputValues[inputValue];
        }
        for (InputNeuron inputNeuron: inputNeurons) {
            inputNeuron.fire();
        }
        for (int currentHiddenLayer = 2; currentHiddenLayer > 1; currentHiddenLayer--) {//TODO Replace with a dynamic solution
            for (HiddenNeuron hiddenNeuron: hiddenNeurons.get(currentHiddenLayer - 1)) {
                hiddenNeuron.fire();
            }
            biasNeurons.get(currentHiddenLayer - 1).fire();
        }
        for (OutputNeuron outputNeuron:outputNeurons) {
            outputNeuron.fire();
        }
        return outputValues;
    }
}
