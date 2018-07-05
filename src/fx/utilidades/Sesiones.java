/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fx.utilidades;

import fx.modelo.Administrador;

/**
 *
 * @author PotatoPower
 */
public class Sesiones {
    private static Administrador sesion;
    
    public static Administrador getSesion(){
        return sesion;
    }
    
    public static void setSesion(Administrador sesion){
        Sesiones.sesion = sesion;
    }
}
