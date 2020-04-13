/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication59;

import java.util.*;

public class JavaApplication59 {
    public static void main(String[] args){
        String a = "asd[gfh[[dfh]hgh]fdfhd[dfg[d]g[d]dg";
        teclado(a);
       
    }
    public static void teclado(String a){
        LinkedList<Character>texto = new LinkedList<>();
        Boolean e=false;
        int cont = 0;
        String b="";
        for (int i = 0; i < a.length(); i++) {
            b = Character.toString(a.charAt(i));
            if(b.equalsIgnoreCase("[")){
                e = true;  
                cont=0;
            }else{
                if(b.equalsIgnoreCase("]")){
                    e = false;
                }
            }
            if(e==true){
                texto.add(cont,a.charAt(i));
                cont++;
            }else{
                if(e==false){
                    texto.offer(a.charAt(i));
                }
            }
        }
        int y=0;
        while(y< a.length()){
            for (int i = 0; i < texto.size(); i++) {
            String w ="";
            w = Character.toString(texto.get(i));
            if(w.equalsIgnoreCase("[") || w.equalsIgnoreCase("]")){
                texto.remove(i);
            }
            }
            y++;
        }
        
        
        String cadena = "";
        for (int i = 0; i < texto.size(); i++) {
            cadena += texto.get(i);
        }
        System.out.println(cadena);
    }
}
