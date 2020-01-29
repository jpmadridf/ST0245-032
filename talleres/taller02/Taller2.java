
package taller2;

public class Taller2 {

    
    public static void main(String[] args) {
        
    }
    
    public static int Alg(int a, int b){
        if(a%b==0){
            return b;
        }else{
            return Alg(b,a%b);
        }
    }
    
    public static boolean Suma(int inicio,int[] num,int target){
        if(inicio==num.length){
            return target==0;
        }else{
            return Suma(inicio+1,num,target) || Suma(inicio+1,num,target-num[inicio]);
        }
    }
    public static void combinations(String s){
        combinationsAux("",s);
    }
    public static void combinationsAux(String base, String s){
        if(s.length()==0){
            System.out.println(base);
        } else {
            combinationsAux(base+s.charAt(0), s.substring(1));
            combinationsAux(base, s.substring(1));
        }
    }
}
