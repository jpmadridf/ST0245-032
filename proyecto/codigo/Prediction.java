import java.io.IOException;
/**
 * Write a description of class Prediction.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Prediction {
    public static void main (String [] args) throws IOException {
        long TInicio, TFin, tiempo;
        TInicio = System.currentTimeMillis();
        String fileNameTrain = "https://raw.githubusercontent.com/mauriciotoro/ST0245-Eafit/master/proyecto/datasets/0_test_balanced_5000.csv";
        int numberOfStudentsTrain = 5000;
        Tree arbol = new Tree (fileNameTrain, numberOfStudentsTrain);
        Node raiz = Tree.getRoot();

        String fileNameTest ="https://raw.githubusercontent.com/mauriciotoro/ST0245-Eafit/master/proyecto/datasets/0_train_balanced_15000.csv";
        int numberOfStudentsTest = 15000;
        String [][] dataSetTest = File.read(fileNameTest, numberOfStudentsTest);
        String [][] dataSetPrediction = File.read(fileNameTest, numberOfStudentsTest);
        String [][] dataSetOriginal = File.read(fileNameTest, numberOfStudentsTest);
        start(raiz, dataSetPrediction, dataSetOriginal);
        TFin = System.currentTimeMillis();
        tiempo = TFin - TInicio;
        System.out.println("Execution time: " + tiempo + " ms");
    }

    public static void start (Node root, String [][] dataSetPrediction, String [][] dataSetOriginal) throws IOException {
        for (int i = 0; i < dataSetPrediction.length; i++) {
            dataSetPrediction[i][77] = Integer.toString(success (root, dataSetPrediction[i]));
        }
        System.out.println("Accuracy " + error(dataSetOriginal, dataSetPrediction));
    }

    public static int success (Node node, String [] student) {
        int data = node.getData();
        String alt = node.getAlt();

        if (student[data] == alt) {
            if (node.getLeft() == null) {
                int success = node.getSuccess();
                if (success == 1 || success == 0){
                    return node.getSuccess();
                }
                else {
                    String[][] dataSet = node.getDataSet();
                    double suc = Double.valueOf(Tree.numInstances(dataSet, dataSet.length, "1"));
                    double noSuc = dataSet.length - suc;
                    if (suc >= noSuc){ 
                        return 1;
                    }else {
                        return 0;
                    }
                }
            }else {
                return success (node.getLeft(), student);
            }
        } else {
            if (node.getRight() == null) {
                int success = node.getSuccess();
                if (success == 1 || success == 0) {
                    return node.getSuccess();
                }
                else {
                    String[][] dataSet = node.getDataSet();
                    double suc = Double.valueOf(Tree.numInstances(dataSet, 77, "1"));
                    double noSuc = dataSet.length - suc;
                    if (suc >= noSuc) {
                        return 1; 
                    }else{ 
                        return 0;
                    }
                }
            }else{
                return success (node.getRight(), student);
            }
        }
    }

    public static double error (String [][] original, String [][] test) {
        double noError = 0;
        for (int i = 0; i < original.length; i++) {
            if (original[i][77].equals(test[i][77])){
                noError++;
            }
        }
        double p = noError/original.length * 100;
        return p;
    }
}
