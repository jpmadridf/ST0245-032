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
public class Fecha {
    
    private int dia;
    private int mes;
    private int año;

    public Fecha(int dia, int mes, int año) {
        this.dia = dia;
        this.mes = mes;
        this.año = año;
    }

    public int getDia() {
        return dia;
    }

    public int getMes() {
        return mes;
    }

    public int getAño() {
        return año;
    }
    
    public int comparar(Fecha otra){
        if(otra.getAño()== año && otra.getMes()==mes && otra.getDia()==dia ){
            return 0;
        }else{
            if(otra.getAño()>año){
                return -1;
            }else{
                if(otra.getAño()<año){
                    return 1;
                }else{
                    if(otra.getMes()>mes){
                        return -1;
                    }else{
                        if(otra.getMes()<mes){
                            return 1;
                        }else{
                            if(otra.getDia()>dia){
                                return -1;
                            }else
                                return 1;
                        }
                    }
                }
            }
        }
        
    }
    
}
