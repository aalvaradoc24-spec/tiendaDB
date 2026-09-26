/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.com.gt.inicio;

//importar package y el formulario
import edu.com.gt.vista.FrmProducto;
//importar las utilidades de java swing
import javax.swing.SwingUtilities;

/**
 *
 * @author ALVA
 * 
 * variable mfv (mostrar formulario en ventana)
 */
public class Inicio {
    
    //Método main, Es el primer método que Java ejecuta al iniciar el programa.
    
    public static void main (String[] args){
    
        // SwingUtilities.invokeLater ayuda a iniciar la ventana Swing correctamente.
        SwingUtilities.invokeLater(() -> {
       
            // Crear y mostrar el formulario principal se llamara formulario
            FrmProducto mfv = new FrmProducto();
            mfv.setVisible(true);
            
        }
        );
        
    }
    
}
