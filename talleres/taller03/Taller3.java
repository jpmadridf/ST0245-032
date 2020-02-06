

package taller3;


public class Taller3 {


    public static void torresDeHannoi(int n) {
	torresDeHannoiAux(n, 1, 2, 3);
    }
    private static void torresDeHannoiAux(int n, int origen, int intermedio, int destino) {
	if(n == 1)
	    {   
		System.out.println("Disk 1 from "+ origen + " to "+ destino);
	    }
	else {
	    torresDeHannoiAux(n - 1, origen, destino, intermedio);
	    System.out.println("Disk "+ n + " from "+ origen + " to "+ destino);
	    torresDeHannoiAux(n - 1, intermedio, origen, destino);
	}
    }
     public static void combinations(String s) { 
	combinationsAux("", s); 
    }
    private static void combinationsAux(String prefix, String s) {  
	if (s.length() != 0) { 
	    System.out.println(prefix + s.charAt(0));   
	    combinationsAux(prefix + s.charAt(0), s.substring(1)); 
	    combinationsAux( prefix , s.substring(1));        
	}
    }
}
