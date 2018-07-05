/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fx.controlador.servicio;

import fx.controlador.dao.AdministradorDao;
import fx.modelo.Administrador;
import java.util.List;

/**
 *
 * @author PotatoPower
 */
public class ServicioAdministrador {
    private AdministradorDao obj;

    public ServicioAdministrador() {
        this.obj = new AdministradorDao();
    }
    
    public boolean guardar(){
        return this.obj.guardar();
    }
    
    public Administrador obtenerAdministrador(){
        return obj.getAdministrador();
    }
    
    public Administrador obtenerAdministrador(Long id){
        return obj.obtener(id);
    }
    
    public List<Administrador> listado(){
        return obj.listar();
    }
    
    public Administrador inicioSesion(String usuario, String clave){
        return obj.inicioSesion(usuario, clave);
    }
}
