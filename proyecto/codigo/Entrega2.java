
package entrega2;

import java.util.*;
import java.io.*;
import java.nio.file.*;

public class Entrega2 {

    private static final double MEGABYTE = 1024L * 1024L;

    public static double bytesToMegabytes(double bytes) {
        return bytes / MEGABYTE;
    }

    public static void leerArchivoCSV(){
        ArrayList<ArrayList<String>> datos = new ArrayList<ArrayList<String>>();
        Path direccionArchivo= Paths.get("datos61.csv");
        try{
            BufferedReader br= Files.newBufferedReader(direccionArchivo);
            String linea;
            while ((linea= br.readLine()) != null){
                String[] datosLinea= linea.split(";");
                ArrayList<String> temp= new ArrayList<String>();
                for(String dato: datosLinea)
                    temp.add(dato);
                datos.add(temp);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        //System.out.println(datos);
        
        Runtime runtime = Runtime.getRuntime();
        runtime.gc();
        long memory = runtime.totalMemory() - runtime.freeMemory();
        System.out.println("Used memory is megabytes: "
            + bytesToMegabytes(memory));
    }
    public static void Eliminar(ArrayList<String> array){
        Scanner entrada = new Scanner(System.in);
        int y;
        System.out.println("Ingrese la posicion que desea eliminar");
        y = entrada.nextInt();
        array.remove(y);
    }
    public static void main(String[] args) throws InterruptedException {
        long inicio = System.currentTimeMillis();
        leerArchivoCSV();
        
        long fin = System.currentTimeMillis();
        double tiempo = (double) ((fin - inicio));
        System.out.println(tiempo +" segundos");
        /**/
    }
}
