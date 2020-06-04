import java.util.*;
import javafx.util.*;
import java.io.*;
/**
 * Write a description of class Tree here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tree {
    private static Node root;
    private static int maxDepth = 10;
    private static int variables = 77;
    private static boolean[] dataUsed =  new boolean[variables];
    private static String[][] dataSetTemp;

    public static String [][] getDataSetTemp () {
        return dataSetTemp;
    }

    public Tree (String fileName, int numberOfStudents) throws IOException {
        String[][] dataSet = File.read(fileName, numberOfStudents);
        dataSetTemp = dataSet;
        dataUsed[0] = true;
        root = create(dataSet, 1);
    }

    public static Node getRoot() {
        return root;
    }

    public static Node create (String[][] array, int depth) {
        if (depth == maxDepth) {
            return null;
        }
        if (stop(dataUsed)){
            return null;
        }
        if (array.length == 0){ 
            return null;
        }

        double minGini = 1;
        int data = 0;
        String alt = "";
        for (int i = 0; i < dataUsed.length; i++) {
            if (!dataUsed[i]) {
                for (String altTemp : getAlternatives(array, i)) {
                    double giniTemp = giniIndexData(array, i, altTemp);
                    if (giniTemp == 0) {
                        return new Node(Integer.parseInt(array[0][variables]), data, alt, null, null, array);
                    } else if (giniTemp < minGini) {
                        data = i;
                        alt = altTemp;
                        minGini = giniTemp;
                    }
                }
            }
        }
        dataUsed[data] = true;
        Pair<String[][], String[][]> newDataSet = split(array, data, alt);

        Node leftNode = create(newDataSet.getKey(), depth++);
        Node rightNode = create(newDataSet.getValue(), depth++);
        return new Node(3, data, alt, leftNode, rightNode, array);
    }

    public static boolean stop (boolean[] dataUsed) {
        for (int i = 0; i < dataUsed.length; i++)
            if (!dataUsed[i])
                return false;
        return true;
    }

    public static TreeSet<String> getAlternatives(String[][] array, int data){
        TreeSet<String> alternatives = new TreeSet();
        for (int i = 0; i < array.length; i++){
            alternatives.add(array[i][data]);
        }
        return alternatives;
    }

    public static int numInstances (String[][] array, int data, String alt) {
        int numInstances = 0;
        for (int i = 0; i < array.length; i++){
            if (array[i][data].equals(alt)){
                numInstances++;
            }
        }
        return numInstances;
    }

    public static Pair<String[][], String[][]> split (String[][] array, int data, String alt) {
        int numInstances = numInstances(array, data, alt);
        String[][] arrayAlt = new String[numInstances][variables];
        String[][] arrayNoAlt = new String[array.length - numInstances][variables];
        int success = 0, noSuccess = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i][data].equals(alt)) {
                arrayAlt[success] = array[i];
                success++;
            } else {
                arrayNoAlt[noSuccess] = array[i];
                noSuccess++;
            }
        }
        return new Pair(arrayAlt, arrayNoAlt);
    }

    public static double giniIndex (String[][] array) {
        int instSuccess = numInstances(array, variables, "1");
        if (array.length != 0) {
            int instNoSuccess = array.length - instSuccess;
            return 1 - Math.pow(Double.valueOf(instSuccess) / array.length, 2) - Math.pow(Double.valueOf(instNoSuccess) / array.length, 2);
        }
        return 1;
    }

    public static double giniIndexData (String[][] array, int data,  String alt){
        Pair<String[][], String[][]> pair = split(array, data, alt);
        double giniIndexSuccess = giniIndex(pair.getKey());
        double giniIndexNoSuccess = giniIndex(pair.getValue());
        return (giniIndexSuccess * pair.getKey().length + giniIndexNoSuccess * pair.getValue().length) / array.length;
    }

}
