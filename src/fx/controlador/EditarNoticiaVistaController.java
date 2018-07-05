/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fx.controlador;

import fx.controlador.servicio.ServicioAdministrador;
import fx.modelo.Noticia;
import fx.modelo.enums.TipoNoticia;
import fx.utilidades.Sesiones;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author PotatoPower
 */
public class EditarNoticiaVistaController {
    @FXML
    private TextField tituloEditField;
    @FXML
    private ComboBox tipoEditField;
    @FXML
    private TextArea contenidoEditField;
    
    private Stage dialogo;
    private Noticia noticia;
    private boolean okClicked = false;
    
    @FXML
    public void initialize() { }

    public void setDialogo(Stage dialogo) {
        this.dialogo = dialogo;
    }

    public void setNoticia(Noticia noticia) {
        this.noticia = noticia;
        
        tituloEditField.setText(noticia.getTitulo());
                
        tipoEditField.getItems().addAll(
                TipoNoticia.DEPORTIVA,
                TipoNoticia.INTERNACIONAL,
                TipoNoticia.NACIONAL,
                TipoNoticia.POLITICA,
                TipoNoticia.SALUD,
                TipoNoticia.OTRAS
        );
        if (noticia.getTipoNoticia() == null) 
            tipoEditField.setValue(TipoNoticia.DEPORTIVA);
        else
            tipoEditField.setValue(noticia.getTipoNoticia());
        
        contenidoEditField.setText(noticia.getContenido());
    }
    
    public boolean isOkClicked() {
        return okClicked;
    }
    
    @FXML
    private void handleOk(){
        if (validarCampos()) {
            noticia.setTitulo(tituloEditField.getText());
            noticia.setTipoNoticia((TipoNoticia) tipoEditField.getValue());
            noticia.setContenido(contenidoEditField.getText());
            ServicioAdministrador aux = new ServicioAdministrador();
            aux.obtenerAdministrador().setId(Sesiones.getSesion().getId());
            noticia.setAdministrador(aux.obtenerAdministrador());
            okClicked = true;
            dialogo.close();
        }
    }
    
    @FXML
    private void handleCancelar() {
        dialogo.close();
    }
    
    private boolean validarCampos(){
        String mensajeError = "";
        
        if (tituloEditField.getText() == null || tituloEditField.getText().trim().length() == 0)
            mensajeError += "¡Campo de título vacío!\n";
        if(contenidoEditField.getText() == null || contenidoEditField.getText().trim().length() == 0)
            mensajeError += "¡Campo de contenido vacío!";
        
        if (mensajeError.length() == 0) {
            return true;
        }else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Campos no válidos");
            alert.setHeaderText(null);
            alert.setContentText("Por favor, revise los siguiente campos: \n"+mensajeError);
            alert.showAndWait();
            return false;
        }
    }
    
}
