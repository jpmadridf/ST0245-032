
package taller9;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Taller9 {

    public static void main(String[] args) {
        
    }
    
//Punto 1    
    
    private ArrayList<ArrayList<Pareja>> tabla;

   
   public Taller9(){
       
    tabla = new ArrayList<>(11);
    for (int i = 0; i < 10; i++) {
        tabla.add(i,tabla.get(i));
    }
   }


    private int funcionHash(String k) {
        return ((int) k.charAt(0)) % 10;
    }

    public int get(String k) {
        return tabla.get(funcionHash(k)).stream().filter(p -> p.name.equals(k)).collect(Collectors.toList())
                .get(0).dato;

    }

    public void put(String k, int v) {
        Pareja nueva = new Pareja(k, v);
        tabla.get(funcionHash(k)).add(nueva);
    }
}

class Pareja {

    String name;
    int dato;

    public Pareja(String name, int dato) {
        this.name = name;
        this.dato = dato;
    }
    
//Punto 2    
    
     public static void add(HashMap empresas,String key, String value){
        empresas.put(key,value);
    }
    public static boolean search(HashMap empresas,String key){
        boolean contain = empresas.containsKey(key);
        if(contain){
            System.out.println(empresas.get(key));
        }
        return contain;
    }
    public static boolean containValue(HashMap empresas,String value){
       return empresas.containsValue(value);
    }
      
}
