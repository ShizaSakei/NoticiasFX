/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fx.controlador.servicio;

import fx.controlador.dao.NoticiaDao;
import fx.modelo.Noticia;
import java.util.List;
import javafx.collections.ObservableList;

/**
 *
 * @author PotatoPower
 */
public class ServicioNoticia {
    private NoticiaDao obj;

    public ServicioNoticia() {
        this.obj = new NoticiaDao();
    }
    
    public boolean guardar(){
        return this.obj.guardar();
    }
    
    public Noticia obtenerNoticia(){
        return obj.getNoticia();
    }
    
    public Noticia obtenerNoticia(Long id){
        return obj.obtener(id);
    }
    
    public void fijarInstanciaNoticia(Noticia noticia){
        obj.fijaInstancia(noticia);
    }
    
    public List<Noticia> listado(){
        return obj.listar();
    }
    
    public boolean eliminar(Long id){
        return obj.eliminar(id);
    }
    
    public ObservableList<Noticia> listarNoticiaAdministrador(Long id){
        return obj.listarNoticiaAdministrador(id);
    }
    
    public List<Noticia> listarNoticiaAdministradorBusqueda(Long id, String texto){
        return obj.listarNoticiaAdministradorBusqueda(id,texto);
    }
}
