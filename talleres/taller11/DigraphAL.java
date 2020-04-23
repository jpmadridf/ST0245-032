
package taller11;

import java.util.ArrayList;
import java.util.LinkedList;
import javafx.util.Pair;
/**
 * Write a description of class Subject here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DigraphAL extends Graph {

    ArrayList<LinkedList<Pair<Integer,Integer>>> nodo;

    public DigraphAL(int size) {
        super(size);
        nodo = new ArrayList<>();
        for (int i = 0; i < size + 1; i++) {
            nodo.add(new LinkedList<>() );

        }
    }

    public void addArc(int source, int destination, int weight) {
        nodo.get(source).add(new Pair<>(destination,weight));
    }

    public ArrayList<Integer> getSuccessors(int vertex) {
        ArrayList<Integer> n = new ArrayList<>(); 
        nodo.get(vertex).forEach(i -> n.add(i.getValue()));
        return n;
    }

    public int getWeight(int source, int destination) {
        int result = 0;
        for (Pair<Integer, Integer> integerIntegerPair : nodo.get(source)) {
            if (integerIntegerPair.getKey() == source ) result = integerIntegerPair.getValue();
        }
        return result;
    }
}

