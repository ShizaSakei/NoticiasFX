/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fx.utilidades;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import org.apache.commons.lang.StringUtils;

/**
 *
 * @author PotatoPower
 */
public class Utilidades extends StringUtils {
    public static StringProperty convertidorSP(String cadena){
        return new SimpleStringProperty(cadena);
    }
    
    public static String formatearFecha(Date fecha){
        String fechaSalida = "";
        try {
            SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yy HH:mm");
            fechaSalida = formato.format(fecha);
        } catch (Exception e) {
            System.out.println("No se pudo formatear la fecha...");
        }
        return fechaSalida;
    }
    
    public static LocalDate formatearFechaLD(Date fecha){
        String fechaSalida = "";
        LocalDate date = null;
        try {
            SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yy");
            fechaSalida = formato.format(fecha);
            
            date = LocalDate.parse(fechaSalida);
        } catch (Exception e) {
            System.out.println("No se pudo formatear la fecha...");
        }
        return date;
    }
}
