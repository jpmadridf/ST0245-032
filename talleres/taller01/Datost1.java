/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datost1;

import javax.swing.JOptionPane;

        
public class Datost1 {

    static Punto punto;
    
    public static void main(String[] args) {
        
        CrearPunto();        
        Coordenadax();
        Coordenaday();
        radio();
        angulo();
        distancia();
    }
    
    static void CrearPunto(){
      int x = Integer.parseInt(JOptionPane.showInputDialog("Ingrese coordenada x"));
      int y = Integer.parseInt(JOptionPane.showInputDialog("Ingrese coordenada y"));
      punto = new Punto(x,y);
      JOptionPane.showMessageDialog(null,"Registro realizado");
    }
    static void Coordenadax(){
        JOptionPane.showMessageDialog(null, "La coordenada x es : " + punto.getX());
    }
    
    static void Coordenaday(){
        JOptionPane.showMessageDialog(null, "La coordenada y es : " + punto.getY());
    }
    
    static void radio(){
        Double radio = Math.sqrt((punto.getX()*punto.getX())+(punto.getY()*punto.getY()));
        JOptionPane.showMessageDialog(null, " El radio es : " + radio );
    }
    static void angulo(){
        Double angulo = Math.atan2(punto.getY(), punto.getX());
        JOptionPane.showMessageDialog(null, "El angulo  es : " + angulo);
    }
    static void distancia(){
        int x = Integer.parseInt(JOptionPane.showInputDialog("Ingrese coordenada x"));
        int y = Integer.parseInt(JOptionPane.showInputDialog("Ingrese coordenada y"));
        double rx = x-punto.getX();
        double ry = y-punto.getY();
        Double distancia = Math.sqrt((rx*rx)+(ry*ry));
        JOptionPane.showMessageDialog(null, "La distancia entre puntos es : " + distancia);
    }
}
