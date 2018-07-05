/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fx.controlador;

import fx.Principal;
import fx.controlador.servicio.ServicioNoticia;
import fx.modelo.Noticia;
import fx.utilidades.Sesiones;
import fx.utilidades.Utilidades;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * @author PotatoPower
 */
public class NoticiasVistaController{

    /**
     * Initializes the controller class.
     */
    @FXML
    private TableView<Noticia> noticiaTabla; 
    @FXML
    private TableColumn<Noticia, String> idColumna;
    @FXML
    private TableColumn<Noticia, String> tituloColumna;
    @FXML
    private TableColumn<Noticia, String> fechaColumna;
    @FXML
    private TableColumn<Noticia, String> tipoColumna;
    
    private Principal principal;
    
    @FXML
    private void initialize(){
        idColumna.setCellValueFactory(
            cellData ->  Utilidades.convertidorSP(
                    cellData.getValue().getId().toString()));        
        tituloColumna.setCellValueFactory(
            cellData -> cellData.getValue().tituloProperty());
        fechaColumna.setCellValueFactory(
            cellData -> Utilidades.convertidorSP(
                    Utilidades.formatearFecha(cellData.getValue().getFecha())));
        tipoColumna.setCellValueFactory(
            cellData -> StringProperty.stringExpression(cellData.getValue().tipoNoticiaProperty()));
        
        /*
        showPersonDetails(null);
        noticiaTabla.getSelectionModel().selectedItemProperty().addListener(
            (observable, oldValue, newValue) -> showPersonDetails(newValue));*/
    }
    
    public void setPrincipal(Principal principal){
        this.principal = principal;
        ServicioNoticia servNoticia = new ServicioNoticia();
        this.principal.setData(servNoticia.listarNoticiaAdministrador(Sesiones.getSesion().getId()));
        noticiaTabla.setItems(this.principal.getData());
    }
    
    @FXML
    private void handleEliminarNoticia(){
        int itemSeleccionado = noticiaTabla.getSelectionModel().getSelectedIndex();
        if (itemSeleccionado >= 0) {
            noticiaTabla.getItems().remove(itemSeleccionado);
        }else{
            // Nothing selected.
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Sin selección");
            alert.setHeaderText(null);
            alert.setContentText("Por favor, seleccione una noticia de la tabla.");
            alert.showAndWait();
        }
    }
    @FXML
    private void handleVerNoticia(){
        ServicioNoticia itemSeleccionado = new ServicioNoticia();
        itemSeleccionado.fijarInstanciaNoticia(noticiaTabla.getSelectionModel().getSelectedItem());
        if (itemSeleccionado.obtenerNoticia().getId() != null){
            principal.mostrarVerNoticiasVista(itemSeleccionado);
        }else{
            // Nothing selected.
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Sin selección");
            alert.setHeaderText(null);
            alert.setContentText("Por favor, seleccione una noticia de la tabla.");
            alert.showAndWait();
        }
    }
    @FXML
    private void handleNuevaNoticia(){
        ServicioNoticia noticiaTemp = new ServicioNoticia();
        boolean okClicked = principal.mostrarEditarNoticiasVista(noticiaTemp);
        if (okClicked){
            noticiaTemp.guardar();
            principal.getData().add(noticiaTemp.obtenerNoticia());
        } 
    }
    
    @FXML
    private void handleEditarNoticia(){
        ServicioNoticia itemSeleccionado = new ServicioNoticia();
        itemSeleccionado.fijarInstanciaNoticia(noticiaTabla.getSelectionModel().getSelectedItem());
        if (itemSeleccionado.obtenerNoticia().getId() != null) {
            boolean okClicked = principal.mostrarEditarNoticiasVista(itemSeleccionado);
            if (okClicked) {
                itemSeleccionado.guardar();
            }
                
        }else{
            // Nothing selected.
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Sin selección");
            alert.setHeaderText(null);
            alert.setContentText("Por favor, seleccione una noticia de la tabla.");
            alert.showAndWait();
        }
    }
    
    @FXML
    private void handleSalir(){
        System.exit(0);
    }
}
