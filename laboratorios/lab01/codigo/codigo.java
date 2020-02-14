
package codigo;


public class codigo {


    public static void main(String[] args) {
        
    }
    
    public static int lcsDNA(String string1, String string2){
        return lcsDNAAux(string1,string2,string1.length(),string2.length());
    }
    
    private static int lcsDNAAux(String string1, String string2, int m, int n) {
        if(m==0 || n==0){
            return 0;
        }
        if(string1.charAt(m-1)==string2.charAt(n-1)){
            return 1 + lcsDNAAux(string1,string2, m-1, n-1);
        }
        return Math.max(lcsDNAAux(string1,string2, m-1, n), lcsDNAAux(string1,string2, m, n-1));
    }

    public static int ways(int n){
        if(n<=2)
            return n;
        return ways(n-1) + ways(n-2);
    }
    
}
