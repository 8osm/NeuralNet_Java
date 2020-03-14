package recognition;
import recognition.neuralnet.NeuralNet;

public class Main {
    public static void main(String[] args) {
//        final int generations = 1000;
//
//        Scanner scanner = new Scanner(System.in);
//        System.out.println(
//                "1. Learn the network\n" +
//                "2. Guess a number"
//        );
//        int choice = scanner.nextInt();
//        switch (choice){
//            case 1:
//                System.out.println("Your choice: 1");
//                learn(generations);
//                break;
//            case 2:
//                System.out.println("Your choice: 2");
//                guess();
//        }
//    }
//    static int calcArraySum(double[] array) {
//        int result = 0;
//        for (int i = 0; i != array.length; i++) result += array[i];
//        return result;
//    }
//
//    static double[] computeResult(double[] input, double[][] weights) {
//        double[] results = new double[weights.length];
//        double[] inputCalc = new double[input.length];
//        for (int i = 0; i != results.length; i++) {
//            for (int j = 0; j != input.length; j++) {
//                inputCalc[j] = input[j] * weights[i][j];
//            }
//            results[i] += sigmoid(calcArraySum(inputCalc));
//        }
//        return results;
//    }
//    static double sigmoid(double input){
//        return (1/( 1 + Math.pow(Math.E,(-1*input))));
//    }
//    static void guess(){
//        Scanner scanner = new Scanner(System.in);
//
//        double[][] w;
//        try {
//            FileInputStream fis = new FileInputStream("/Users/ivanm/weights.dat");
//            ObjectInputStream iis = new ObjectInputStream(fis);
//            w = (double[][]) iis.readObject();
//            iis.close();
//            fis.close();
//        } catch (IOException e) {
//            System.out.println("File not found, did you teach the network first?");
//            return;
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//            return;
//        }
//
//        System.out.println("Input grid:");
//
//        String fullLine = "";
//        double[] results;
//        int result = 0;
//        double[] a = new double[15];
//
//        for (int i = 0; i != 5; i++) fullLine += scanner.nextLine();
//        char[] charInput = fullLine.toCharArray();
//        for (int i = 0; i != a.length; i++) {
//            if (charInput[i] == '_') {
//                a[i] = 0;
//            } else {
//                a[i] = 1;
//            }
//        }
//
//        results = computeResult(a, w);
//        double max = results[0];
//        for (int i = 1; i < results.length; i++)
//            if (results[i] > max) {
//                max = results[i];
//            }
//        for (int i = 0; i < results.length; i++)
//            if (results[i] == max) {
//                result = i;
//                break;
//            }
//
//        System.out.println(Arrays.toString(results));
//        System.out.println("This number is " + (result == 9 ? 0 : result + 1));
//    }
//    static void learn(int generations){
//        final double[][] DATASET_INPUTS = {
//                {0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0},
//                {1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1},
//                {1, 1, 1, 0, 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1},
//                {1, 0, 1, 1, 0, 1, 1, 1, 1, 0, 0, 1, 0, 0, 1},
//                {1, 1, 1, 1, 0, 0, 1, 1, 1, 0, 0, 1, 1, 1, 1},
//                {1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1},
//                {1, 1, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1},
//                {1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1},
//                {1, 1, 1, 1, 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1},
//                {1, 1, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1}
//        };
//        Random random = new Random();
//        double[] results;
//        double[][] w = new double[10][15];
////        double[][] w = {
////                {-1, 1, -1, -1, 1, -1, -1, 1, -1, -1, 1, -1, -1, 1, -1},
////                {1, 1, 1, -1, -1, 1, 1, 1, 1, 1, -1, -1, 1, 1, 1},
////                {1, 1, 1, -1, -1, 1, 1, 1, 1, -1, -1, 1, 1, 1, 1},
////                {1, -1, 1, 1, -1, 1, 1, 1, 1, -1, -1, 1, -1, -1, 1},
////                {1, 1, 1, 1, -1, -1, 1, 1, 1, -1, -1, 1, 1, 1, 1},
////                {1, 1, 1, 1, -1, -1, 1, 1, 1, 1, -1, 1, 1, 1, 1},
////                {1, 1, 1, -1, -1, 1, -1, -1, 1, -1, -1, 1, -1, -1, 1},
////                {1, 1, 1, 1, -1, 1, 1, 1, 1, 1, -1, 1, 1, 1, 1},
////                {1, 1, 1, 1, -1, 1, 1, 1, 1, -1, -1, 1, 1, 1, 1},
////                {1, 1, 1, 1, -1, 1, 1, -1, 1, 1, -1, 1, 1, 1, 1}
////        };
//        double[][][] dw = new double[10][10][15];
//        int genCount = generations;
//
//        System.out.println("Learning...");
//        for(int i = 0; i != w.length; i++){
//            for(int j = 0; j != w[0].length; j++) w[i][j] = 0;
//        }
//        for(double[] el : w){
//            System.out.println(Arrays.toString(el));
//        }
//        System.out.println("\n");
//        while (genCount>=0){
//
//            for(int i = 0; i != DATASET_INPUTS.length; i++){
//                results = computeResult(DATASET_INPUTS[i], w);
//                for(int j = 0; j != DATASET_INPUTS.length; j++){
//                    for (int k = 0; k != DATASET_INPUTS[j].length; k++){
//                        dw[i][j][k] = (0.5 * DATASET_INPUTS[i][k] * ( (i == j?1:0) - results[j]));
//                    }
//                }
//            }
//            double result = 0;
//            for (int i = 0; i != 10; i++) {
//                for (int j = 0; j != 15; j++) {
//                    for (int k = 0; k != 10; k++) {
//                        result += dw[k][i][j];
//                    }
//                    w[i][j] += result/10;
//                    result = 0;
//                }
//            }
//
//            genCount--;
//        }
//
//        try {
//            for(double[] el : dw[1]){
//                System.out.println(Arrays.toString(el));
//            }
//            FileOutputStream fos = new FileOutputStream("/Users/ivanm/weights.dat");
//            ObjectOutputStream oos = new ObjectOutputStream(fos);
//            oos.writeObject(w);
//            oos.close();
//            fos.close();
//            FileInputStream fis = new FileInputStream("/Users/ivanm/weights.dat");
//            ObjectInputStream iis = new ObjectInputStream(fis);
//            double[][] wtest = (double[][]) iis.readObject();
//            iis.close();
//            fis.close();
//            System.out.println(Arrays.deepEquals(w, wtest));
//            System.out.println("Done! Saved to the file.");
//        } catch (Exception e) {
//            System.out.println("Error saving to file!");
//        } for
        for (int i = 4; i > 0; i--) {
            System.out.println(1);
        }
        NeuralNet neuralNet = new NeuralNet(2, 15, 10, 12);
        System.out.println(neuralNet.guess(new double[]{1,0,1,0,1,0,1,0,1,0,1,0,1,0,1}).toString());
    }
}