
package taller6;



public class Taller6 {
    
    public class MiArrayList
{
    private int size= 0;
    private static final int capacity= 10;
    private int[] elements;

    public MiArrayList (){
        size= 0;
        elements = new int [capacity];
    }

    public int size(){
        return size; 
    }

    public void add(int e){
        add(size,e);
    }

    public int get(int i) throws Exception {
        if (i >= size || i<0)
            throw new Exception("index out of bound exception index = "+i);
        else
            return elements[i];
    }

    public void add(int i, int e){
        int [] temp= new int[size+1];
        for (int j=0; j<i; j++){
            temp[j]= elements[j];
        }
        size++;
        temp[i]= e;
        for (int j=i+1; j<size; j++){
            temp[j]= elements[j-1];
        }
        elements= temp;
    }

    public void del(int i){
        int [] temp = new int[size-1];
        for (int j=0; j<i; j++){
            temp[j] = elements[j];
        }
        for(int j = i+1 ; j < size ; j++){
            temp[j-1] = elements[j];
        }
        elements = temp;
    }
}
    
}
