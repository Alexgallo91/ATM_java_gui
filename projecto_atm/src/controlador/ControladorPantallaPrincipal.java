
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.ModeloPantallPrincipal;
import utils.Utils;
import vista.VistaPantallaPrincipal;

public class ControladorPantallaPrincipal {
    
    ModeloPantallPrincipal modelo;
    VistaPantallaPrincipal vista;
    
    //controladores para llamadas a otras vistas
    ControladorAtm controladorAtm;
    
    public ControladorPantallaPrincipal(){
        modelo = new ModeloPantallPrincipal();
        vista = new VistaPantallaPrincipal();
        
        vista.setVisible(true);
        vista.agregarListener(new PantallaPrincipalListener());
        
        controladorAtm = new ControladorAtm();
    }
   
    class PantallaPrincipalListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            
            if(e.getSource() == vista.jButton1){
     
                if (modelo.verificarPassword(new String(vista.jPasswordField1.getPassword()))){
                    //muestra la pantalla del ATM
                    controladorAtm.vistaAtm.setVisible(true);
                    vista.setVisible(false);
                } else{
                    Utils.mensaje.mostrarMensaje("Favor de ingresar el PIN correctamente");
                }
            }
            
        }
        
    }
    
}
