/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package digrapham;

import java.util.ArrayList;

public class DigraphAM extends Graph {
	
	int[][] mat;
	public DigraphAM(int size) {
		super(size);
                mat = new int[size][size];
            for(int i=1; i<=size; i++){
                mat[i][0] = i;
                mat[0][i] = i;
            }
	}

	public void addArc(int source, int destination, int weight) {
		mat[source][destination] = weight;
	}

	public ArrayList<Integer> getSuccessors(int vertex) {
		ArrayList<Integer> np= new ArrayList<>();
     	for(int i=1; i<=size; i++){
        	if(mat[vertex][i]!=  0 ){
         		np.add(mat[0][i]);
        	}
      	}	
     	return np; 
	}
	
	public int getWeight(int source, int destination) {
		return mat[source][destination];
	}

}
