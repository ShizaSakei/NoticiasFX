/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fx.controlador;

import fx.Principal;
import fx.controlador.servicio.ServicioAdministrador;
import fx.utilidades.Sesiones;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author PotatoPower
 */
public class LoginVistaController {
    @FXML
    private TextField campoUsuarioLogin;
    @FXML
    private PasswordField campoClaveLogin;
    
    private Stage ventana;
    private Principal principal;
    /**
     * Initializes the controller class.
     */
    @FXML
    public void initialize() {        
    }    
    
    public void setDialogStage(Stage dialogStage) {
        this.ventana = dialogStage;
    }
    
    @FXML
    private void loginIngresar() {
        if (validarCampos()) {
            ServicioAdministrador servAdmin = new ServicioAdministrador();
            Sesiones.setSesion(servAdmin.inicioSesion(campoUsuarioLogin.getText(), campoClaveLogin.getText()));
            if (Sesiones.getSesion() == null) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Incorrecto");
                alert.setHeaderText(null);
                alert.setContentText("¡Usuario y/o contraseña incorrectos!");
                alert.showAndWait();
            }else{
                ventana.close();
                principal.iniciarRaiz();
            }
        }
    }
    
    @FXML
    private void loginCerrar() {
        ventana.close();
    }
    
    private boolean validarCampos(){
        String errorMessage = "";
        if (campoUsuarioLogin.getText() == null || campoUsuarioLogin.getText().length() == 0) {
            errorMessage += "\tUsuario\n"; 
        }
        if (campoClaveLogin.getText() == null || campoClaveLogin.getText().length() == 0) {
            errorMessage += "\tContraseña\n"; 
        }
        
        if (errorMessage.length() == 0) {
            return true;
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Campos no válidos");
            alert.setHeaderText(null);
            alert.setContentText("Campos vacíos: \n"+errorMessage);
            alert.showAndWait();
            return false;
        }
    }
    
    public void setPrincipal(Principal principal){
        this.principal = principal;
    }
}
