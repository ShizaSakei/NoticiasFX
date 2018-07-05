/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fx.controlador.dao;

import fx.controlador.Conexion;
import fx.modelo.Noticia;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author PotatoPower
 */
public class NoticiaDao extends AdaptadorDao<Noticia>{
    private Noticia noticia;
    
    public NoticiaDao() {
        super(new Conexion(), Noticia.class);
    }
    
    public Noticia getNoticia(){
        if(noticia == null)
            noticia = new Noticia();
        return noticia;
    }
    
    public void fijaInstancia(Noticia noticia){
        this.noticia = noticia;
    }
    
    public boolean guardar(){
        boolean band = false;
        try {
            if (noticia.getId() != null) {
                List<Noticia> lista = listar();
                for (Noticia noti : lista) {
                    if (noti.getId().intValue() == this.noticia.getId().intValue()) {
                        this.guardar(noticia, lista.indexOf(noti));
                        break;
                    }
                }          
            }else{
                this.noticia.setId(generarID());
                this.guardar(noticia);
            }
            band = true;
        } catch (IOException e) {
            System.out.println("No se pudo guardar "+e);
        }
        return band;
    }
    
    public boolean eliminar(Long id) {
        boolean band = false;        
        try {
            this.fijaInstancia(this.obtener(id));
            this.eliminar(noticia);
            band = true;
        } catch (IOException e) {
            System.out.println("No se pudo eliminar "+e);
        }
        return band;
    }
    
    public ObservableList<Noticia> listarNoticiaAdministrador(Long id){
        ObservableList<Noticia> listado = FXCollections.observableArrayList();
        for (Noticia noti : listar()) {
            if (noti.getAdministrador().getId().intValue() == id.intValue())
                listado.add(noti);
        }
        return listado;
    }
    
    public List<Noticia> listarNoticiaAdministradorBusqueda(Long id, String texto){
        List<Noticia> listado = new ArrayList<>();
        for (Noticia noti : listarNoticiaAdministrador(id)) {
            if (noti.getTitulo().toLowerCase().contains(texto.toLowerCase()))
                listado.add(noti);
        }
        return listado;
    }
}
