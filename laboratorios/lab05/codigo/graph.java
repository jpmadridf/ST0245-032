/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package punto1;

import java.util.*;
import java.io.*;

public class graph
{
    private ArrayList<LinkedList<Vertice>> grafoConListas;
    ArrayList <Vertice> vertices = new ArrayList<Vertice>();
    public  void main(){
        readFile();
        int d = vertices.size();
        DigraphAL(d);
    }
    private void readFile(){
        Scanner scan = new Scanner (System.in);
        System.out.print("Enter file name:");
        String nombreDelArchivo = scan.nextLine();
        try {            
            BufferedReader br = new BufferedReader(new FileReader(nombreDelArchivo));
            String lineaActual = br.readLine();
            lineaActual = br.readLine(); 
            int index = 0;
            while (lineaActual != null){ 
                String [] coordenates = lineaActual.split(" ");
                Vertice v = new Vertice(Integer.parseInt(coordenates[0]),
                        Double.parseDouble(coordenates[1]),
                        Double.parseDouble(coordenates[2]), coordenates[3]);
                vertices.add(v);
                lineaActual = br.readLine();
            }
        }
        catch(IOException ioe) {
            System.out.println("There's a problem with the file");
        }
    }

    private void DigraphAL(int size) {
        grafoConListas = new ArrayList<LinkedList<Vertice>>();
        for(int i = 1; i<=size; i++){
            grafoConListas.add(new LinkedList<Vertice>() );
        }
    }

    public void addArc(int Id, double x, double y, String name) {
        grafoConListas.add(new Vertice(Id, x, y, name)); 
    }

    public ArrayList<Integer> getSuccessors(int vertex) {
        ArrayList<Integer> respuestas = new  ArrayList();
        for(int i = 0; i < grafoConListas.size(); i++){
            respuestas.add(grafoConListas.get(vertex).get(i).getKey());
        }
        return respuestas;
    }
}
