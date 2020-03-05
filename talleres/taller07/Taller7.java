
package taller7;



public class Taller7 {


    public static void main(String[] args) {
        
    }
    public class nodo{
        public int dato;
        public nodo siguiente;
        public nodo(int e){
            dato = e;
        }
    }
    
    public class linkedList{
        public nodo primer;
        public int size;
        public linkedList(){
            primer= null;
            size= 0;
        }
        
        private String toString(nodo nodo){
            if (nodo == null) return "]";
            else return nodo.dato + "," + toString(nodo.siguiente);
        }
        
        public String toString(){
            return "["+ toString(primer);
        }
        
        private int posicion (nodo n, int e){
            int i=0;
            while(n != null){
                if (n.dato == e) 
                    return i;
                n= n.siguiente;
                i++;
            }
            return -1;
        }
        public void insertar(int e){
            nodo nuevo= new nodo(e);
            nuevo.siguiente= primer;
            primer= nuevo;
            size++;
        }
        
        public void insertar(int e, int i){
            if(i == 0) insertar(e);
            nodo nuevo = new nodo(e);
            nodo anterior = get(i-1);
            nuevo.siguiente= anterior.siguiente;
            anterior.siguiente= nuevo;
        }
        
        private nodo get(int i){
            nodo temp= primer;
            for (int j = 1; j <= i; j++)
                temp= temp.siguiente;
            return temp;
        }
        
        private boolean Get(int i){
            nodo temp= primer;
            for (int j = 1; j <= i; j++)
                temp= temp.siguiente;
            return true;
        }
        
        public void eliminar(){
            primer= primer.siguiente;
        }
        
        public void eliminar(int i){
            if (i==0) eliminar();
            nodo temp= get(i-1);
            temp.siguiente= get(i+1);
        }
        
        public boolean contains(int data) {
        try {
            for (int i = 0; i < size; i++) {
                if ( Get(data) == true) {
                    return true;
                }
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("La posicion no existe");
        }
        return false;
        }
    }
    
}
