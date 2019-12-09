/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo;

import utils.Utils;


public class ModeloAtm {

    public boolean verificarPassword(String pass) {
        return pass.equals("1234");
    }

    public void depositarSaldo(double saldo) {
        Utils.dineroUsuario += saldo;
        Utils.mensaje.mostrarMensaje(String.format("Deposito exitoso, tienes un "
                + "saldo de: $%.2f", Utils.dineroUsuario));
    }
    
    public void retirarSaldo(double saldo){
        Utils.dineroUsuario -= saldo;
        Utils.mensaje.mostrarMensaje(String.format("Has retirado $%.2f y tu "
                + "saldo actual es: $%.2f", saldo, Utils.dineroUsuario));
    }
}
