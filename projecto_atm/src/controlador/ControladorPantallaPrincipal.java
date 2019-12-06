/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.ModeloPantallPrincipal;
import utils.Utils;
import vista.VistaMensaje;
import vista.VistaPantallaPrincipal;

/**
 *
 * @author Alexgallo91
 */
public class ControladorPantallaPrincipal {
    
    ModeloPantallPrincipal modelo;
    VistaPantallaPrincipal vista;
    
    //controladores para llamadas a otras vistas
    ControladorAtm controladoreAtm;
    
    
    
    public ControladorPantallaPrincipal(){
        modelo = new ModeloPantallPrincipal();
        vista = new VistaPantallaPrincipal();
        
        vista.setVisible(true);
        vista.agregarListener(new PantallaPrincipalListener());
        
        controladoreAtm = new ControladorAtm();
    }
   
    class PantallaPrincipalListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            
            if(e.getSource() == vista.jButton1){
     
                if (modelo.verificarPassword(new String(vista.jPasswordField1.getPassword()))){
                    
                } else{
                    Utils.mensaje.mostrarMensaje("Favor de ingresar el PIN correctamente");
                }
            }
            
        }
        
    }
    
}
