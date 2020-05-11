/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package punto2;

import java.io.*;
import java.util.*;
/**
 * Write a description of class ff here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Punto2{
    public static void main (String [] args){
        Punto2 ex = new Punto2();
        DigraphAM graph1 = new DigraphAM(3);
        graph1.addArc(0, 1, 1);
        graph1.addArc(1, 2, 1);
        graph1.addArc(2, 0, 1);
        boolean ans1 = ex.isBipartite(graph1, 0, 3);
        if(ans1){
            System.out.println("BICOLORABLE");
        }else{
            System.out.println("NOT BICOLORABLE");
        }
        DigraphAM graph2 = new DigraphAM(3);
        graph2.addArc(0, 1, 1);
        graph2.addArc(1, 2, 1);
        boolean ans2 = ex.isBipartite(graph2, 0, 3);
        if(ans2){
            System.out.println("BICOLORABLE");
        }
        else{ 
            System.out.println("NOT BICOLORABLE");
        }
        DigraphAM graph3 = new DigraphAM(9);
        graph3.addArc(0, 1, 1);
        graph3.addArc(0, 2, 1);
        graph3.addArc(0, 3, 1);
        graph3.addArc(0, 4, 1);
        graph3.addArc(0, 5, 1);
        graph3.addArc(0, 6, 1);
        graph3.addArc(0, 7, 1);
        graph3.addArc(0, 8, 1);
        boolean ans3 = ex.isBipartite(graph3, 0, 9);
        if(ans3){ 
            System.out.println("BICOLORABLE");
        }else {
            System.out.println("NOT BICOLORABLE");
        }
    }
    boolean isBipartite(DigraphAM g,int src, int V){
        int colorArr[] = new int[V]; 
        for (int i=0; i<V; ++i){
            colorArr[i] = -1; 
        }
        colorArr[src] = 1; 
        LinkedList<Integer>q = new LinkedList<Integer>(); 
        q.add(src); 
        while (q.size() != 0) {
            int u = q.poll(); 
            if(g.getWeight(u, u) == 1){
                return false; 
            } 
            for (int v=0; v<V; ++v){  
                if (g.getWeight(u, v)==1 && colorArr[v]==-1){ 
                    colorArr[v] = 1-colorArr[u]; 
                    q.add(v);
                }else if (g.getWeight(u, v)==1 && colorArr[v]==colorArr[u]){ 
                    return false; 
                }
            } 
        }
        return true; 
    } 
}