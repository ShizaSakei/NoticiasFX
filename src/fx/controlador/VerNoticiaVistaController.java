/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fx.controlador;

import fx.modelo.Noticia;
import fx.utilidades.Sesiones;
import fx.utilidades.Utilidades;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author PotatoPower
 */
public class VerNoticiaVistaController {
    @FXML
    private Label tituloLabel;
    @FXML
    private Label tipoLabel;
    @FXML
    private Label fechaLabel;
    @FXML
    private Label contenidoLabel;
    @FXML
    private Label administradorLabel;
    
    private Stage dialogo;
    private Noticia noticia;
    
    @FXML
    public void initialize() { }    
    
    public void setNoticia(Noticia noticia) {
        this.noticia = noticia;
        
        tituloLabel.setText(noticia.getTitulo());
        tipoLabel.setText(noticia.getTipoNoticia().getTipo());
        fechaLabel.setText(Utilidades.formatearFecha(noticia.getFecha()));
        contenidoLabel.setText(noticia.getContenido());
        administradorLabel.setText(Sesiones.getSesion().getNombres());
    }

    public void setDialogo(Stage dialogo) {
        this.dialogo = dialogo;
    }
        
}
