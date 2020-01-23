/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fecha;

import javax.swing.JOptionPane;

/**
 *
 * @author juanpablomadridflorez
 */
public class principal {
    
    public static void main(String[] args) {
        int dia = Integer.parseInt(JOptionPane.showInputDialog("ingrese el dia"));
        int mes = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el mes"));
        int año = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el año"));
        Fecha fecha1 = new Fecha(dia,mes,año);
        Fecha fecha2 = new Fecha(20,01,2019);
        JOptionPane.showMessageDialog(null,fecha1.comparar(fecha2));
    }
}
