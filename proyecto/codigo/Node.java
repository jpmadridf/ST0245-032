/**
 * Write a description of class Leerdatos here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
/**
 * Write a description of class Node here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Node {
    private int success;
    private int data;
    private String alt;
    private Node left;
    private Node right;
    private String[][] dataSet;


    public Node (int success, int data, String alt, Node left, Node right, String[][] dataSet) {
        this.success = success;
        this.data = data;
        this.alt = alt;
        this.left = left;
        this.right = right;
        this.dataSet = dataSet;
    }

    public int getSuccess() {
        return success;
    }

    public int getData() {
        return data;
    }

    public String getAlt() {
        return alt;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public String [][] getDataSet() {
        return dataSet;
    }

}
