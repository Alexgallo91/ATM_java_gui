/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.ModeloAtm;
import vista.VistaAtm;
import vista.VistaDepositoDinero;
import vista.VistaRetiroDinero;
import utils.Utils;

public class ControladorAtm {

    ModeloAtm modelo;
    VistaAtm vistaAtm;
    VistaDepositoDinero vistaDepositoDinero;
    VistaRetiroDinero vistaRetiroDinero;

    public ControladorAtm() {
        modelo = new ModeloAtm();
        vistaAtm = new VistaAtm();
        vistaDepositoDinero = new VistaDepositoDinero();
        vistaRetiroDinero = new VistaRetiroDinero();

        //agrega los listeners
        this.vistaAtm.agregarListener(new AtmListener());
        this.vistaDepositoDinero.agregarListener(new AtmListener());
        this.vistaRetiroDinero.agregarListener(new AtmListener());

        //establece el saldo del usuario
        this.vistaAtm.campoSaldo.setText(Utils.obtenerSaldoTextoUsuario());
    }

    class AtmListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == vistaAtm.btnDeposito) {
                vistaDepositoDinero.actualizarPantalla();
                vistaDepositoDinero.setVisible(true);
            } else if (e.getSource() == vistaAtm.btnRetirar) {
                vistaRetiroDinero.actualizarPantalla();
                vistaRetiroDinero.setVisible(true);
            } else if (e.getSource() == vistaDepositoDinero.btnDepositar) {
                if (Utils.esDouble(vistaDepositoDinero.campoDeposito.getText())) {

                    double saldo = Utils.obtenerCantidadDouble(
                            vistaDepositoDinero.campoDeposito.getText());

                    if (saldo <= 0) {
                        Utils.mensaje.mostrarMensaje("Favor de ingresar una cantidad mayor a 0");
                    } else {
                        modelo.depositarSaldo(saldo);
                        vistaAtm.actualizarPantalla();
                        vistaDepositoDinero.actualizarPantalla();
                    }
                } else {
                    Utils.mensaje.mostrarMensaje("Favor de ingresar una cantidad mayor a 0");
                }
            } else if (e.getSource() == vistaRetiroDinero.btnRetirar) {
                if (Utils.esDouble(vistaRetiroDinero.campRetiro.getText())) {
                    double saldo = Utils.obtenerCantidadDouble(
                            vistaRetiroDinero.campRetiro.getText());

                    if (saldo <= 0) {
                        Utils.mensaje.mostrarMensaje("Ingresa una cantidad "
                                + "mayor a 0");
                        return;
                    }

                    if (saldo > Utils.dineroUsuario) {
                        Utils.mensaje.mostrarMensaje("Saldo insufiente, "
                                + "ingresa una cantidad menor");
                    } else {
                        modelo.retirarSaldo(saldo);
                        vistaAtm.actualizarPantalla();
                        vistaRetiroDinero.actualizarPantalla();
                    }
                } else {
                    Utils.mensaje.mostrarMensaje("Favor de ingresar una cantidad mayor a 0");
                }
            }

        }

    }

}
