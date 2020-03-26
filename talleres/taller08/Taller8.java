
package taller8;

import java.util.Stack;
import java.util.Queue;


public class Taller8 {


    public static void main(String[] args) {
        // TODO code application logic here
    }
    public static int notacionPolaca(String str){
        String[] p = str.split(" "); 
        Stack<Integer> stack = new Stack<>();

        for(int i=0;i<p.length;i++){
            if(p[i].equals("+")){
                stack.push(stack.pop()+stack.pop() );
            }
            else if(p[i].equals("*")){
                stack.push(stack.pop()*stack.pop());
            }
            else if(p[i].equals("-")){
                stack.push( stack.pop()-stack.pop());
            }
            else if(p[i].equals("/")){
                stack.push(stack.pop() / stack.pop());
            }
            else{
                stack.push(Integer.parseInt(p[i]));
            }
        }
        return stack.pop();
    }

    public static Stack<Integer> inversa (Stack<Integer> stack){
        int n = stack.size();
        Stack<Integer> temp = new Stack<Integer>();
        for(int i = 0; i < n; i++) 
            temp.add(stack.pop());
        return temp;
    }

    public static void solicitudes(Queue<Clientes> clientes, Stack<Neveras> neveras){
        while(!(clientes.isEmpty())){
            if (neveras.isEmpty()){
                System.out.println("Ya no quedan neveras.");
                break;
            }else{
                Neveras nevera = neveras.pop();
                Clientes cliente = clientes.poll();
                System.out.println("Entregar la nevera: " + nevera + " a: " + cliente);
            }
        }
    }

    
}
