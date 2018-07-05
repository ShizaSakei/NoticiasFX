/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fx;

import fx.controlador.EditarNoticiaVistaController;
import fx.controlador.LoginVistaController;
import fx.controlador.NoticiasVistaController;
import fx.controlador.VerNoticiaVistaController;
import fx.controlador.servicio.ServicioNoticia;
import fx.modelo.Noticia;
import java.io.IOException;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author PotatoPower
 */
public class Principal extends Application{
    private ObservableList<Noticia> data = FXCollections.observableArrayList();
    
    private Stage primaryStage;
    private BorderPane rootLayout;

    public void setData(ObservableList<Noticia> data) {
        this.data = data;
    }

    public ObservableList<Noticia> getData() {
        return data;
    }
    
    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Noticias");
        
        mostrarLoginVista();
    }
    
    public void iniciarRaiz(){
        try {
            FXMLLoader cargador = new FXMLLoader();
            cargador.setLocation(Principal.class.getResource("vista/RaizVista.fxml"));
            rootLayout = (BorderPane) cargador.load();
            
            Scene escena = new Scene(rootLayout);
            primaryStage.setScene(escena);
            mostrarNoticiasVista();
            primaryStage.show();
        } catch (Exception e) {
        }
    }
    
    public void mostrarLoginVista(){
        try{
            FXMLLoader cargador = new FXMLLoader();
            cargador.setLocation(Principal.class.getResource("vista/LoginVista.fxml"));
            AnchorPane pagina = (AnchorPane) cargador.load();
            
            Stage ventana = new Stage();
            ventana.setTitle("Ingreso al Sistema");
            ventana.initModality(Modality.WINDOW_MODAL);
            ventana.initOwner(primaryStage);
            Scene escena = new Scene(pagina);
            ventana.setScene(escena);
            
            LoginVistaController controlador = cargador.getController();
            controlador.setDialogStage(ventana);
            controlador.setPrincipal(this);
            ventana.showAndWait();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    
    private void mostrarNoticiasVista(){
        try {
            FXMLLoader cargador = new FXMLLoader();
            cargador.setLocation(Principal.class.getResource("vista/NoticiasVista.fxml"));
            AnchorPane noticiasVista = (AnchorPane) cargador.load();
            
            rootLayout.setCenter(noticiasVista);
            
            NoticiasVistaController controlador = cargador.getController();
            controlador.setPrincipal(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public boolean mostrarEditarNoticiasVista(ServicioNoticia noticia){
        try {
            FXMLLoader cargador = new FXMLLoader();
            cargador.setLocation(Principal.class.getResource("vista/EditarNoticiaVista.fxml"));
            AnchorPane pagina = (AnchorPane) cargador.load();
            
            Stage dialogo = new Stage();
            dialogo.setTitle("Editar Noticia");
            dialogo.initModality(Modality.WINDOW_MODAL);
            dialogo.initOwner(primaryStage);
            Scene escena = new Scene(pagina);
            dialogo.setScene(escena);
            
            EditarNoticiaVistaController controlador = cargador.getController();
            controlador.setDialogo(dialogo);
            controlador.setNoticia(noticia.obtenerNoticia());
            
            dialogo.showAndWait();
            
            return controlador.isOkClicked();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public void mostrarVerNoticiasVista(ServicioNoticia noticia){
        try {
            FXMLLoader cargador = new FXMLLoader();
            cargador.setLocation(Principal.class.getResource("vista/VerNoticiaVista.fxml"));
            AnchorPane pagina = (AnchorPane) cargador.load();
            
            Stage dialogo = new Stage();
            dialogo.setTitle("Ver Noticia");
            dialogo.initModality(Modality.WINDOW_MODAL);
            dialogo.initOwner(primaryStage);
            Scene escena = new Scene(pagina);
            dialogo.setScene(escena);
            
            VerNoticiaVistaController controlador = cargador.getController();
            controlador.setDialogo(dialogo);
            controlador.setNoticia(noticia.obtenerNoticia());
            
            dialogo.showAndWait();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public Stage getPrimaryStage() {
        return primaryStage;
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
