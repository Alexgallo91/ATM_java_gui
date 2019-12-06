/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.ModeloAtm;
import modelo.ModeloPantallPrincipal;
import vista.VistaAtm;
import vista.VistaPantallaPrincipal;

/**
 *
 * @author Alexgallo91
 */
public class ControladorAtm {
    
    ModeloAtm modelo;
    VistaAtm vista;
    
    public ControladorAtm(){
        modelo = new ModeloAtm();
        vista = new VistaAtm();
    }
    
    class AtmListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
          
            
        }
        
    }
    
}
