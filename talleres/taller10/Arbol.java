
package arbol;


public class Arbol
{
    class Nodo{
        public Nodo izquierdo, derecho;
        public int data;

        public Nodo (int data){
            this.data= data;
        }
    }

    public Nodo raiz;

    public boolean buscar (int n){
        return buscar(raiz, n);
    }

    private boolean buscar (Nodo nodo, int n){
        if (nodo == null) return false;
        if (nodo.data == n) return true;
        if (n < nodo.data) return buscar(nodo.izquierdo, n);
        return buscar(nodo.derecho, n);
    }

    public void insertar (int n){
        if (raiz== null) raiz= new Nodo(n);
        else insertar (raiz, n);
    }

    private void insertar (Nodo nodo, int n){
        if (nodo.data == n) return;
        if (n < nodo.data){
            if (nodo.izquierdo != null) insertar(nodo.izquierdo, n);
            else nodo.izquierdo= new Nodo(n);
        }
        if (n > nodo.data){
            if (nodo.derecho != null) insertar(nodo.derecho, n);
            else nodo.derecho= new Nodo(n);
        }
    }
}
