import java.util.*;
import java.io.*;
import java.net.*;
/**
 * Write a description of class File here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class File {
    // Para leer todos los datos.
    public static String[][] read (String fileName, int n) throws IOException{
        String[][] array = new String[n][78];

        URL url = new URL(fileName);
        InputStream in = url.openStream();
        Scanner inFile = new Scanner (new InputStreamReader(in));
        try {
            inFile.nextLine();
            int num = 0;
            while (inFile.hasNextLine()) {
                String line = inFile.nextLine();
                String[] cut = line.split(";");
                array[num] = cut;
                num++;
            }
        } catch (Exception e) {
            System.out.println("An error has ocurred reading the dataset.");
        }
        return array;
    }

}
