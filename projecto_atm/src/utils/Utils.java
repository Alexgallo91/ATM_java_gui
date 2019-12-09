/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import vista.VistaMensaje;

public class Utils {

    public static VistaMensaje mensaje = new VistaMensaje();
    public static double dineroUsuario = 1000.00;

    public static String obtenerSaldoTextoUsuario() {
        return String.format("$%.2f", Utils.dineroUsuario);
    }

    public static boolean esDouble(String numero) {
        boolean esDouble = true;

        try {
            Double.parseDouble(numero);
        } catch (NumberFormatException e) {
            esDouble = false;
        }

        return esDouble;
    }

    public static double obtenerCantidadDouble(String numero){
        return Double.parseDouble(numero);
    }
}
