/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fx.modelo;

import fx.modelo.enums.TipoNoticia;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author PotatoPower
 */

public class Noticia implements Serializable{
    private Long id;
    private StringProperty titulo, contenido;
    private Date fecha;
    private ObjectProperty<TipoNoticia> tipoNoticia;
    private Administrador administrador;
    private List<Multimedia> listMultimedia = new ArrayList<>();
    private List<Comentario> listComentario = new ArrayList<>();

    public Noticia() {
        this.titulo = new SimpleStringProperty();
        this.contenido = new SimpleStringProperty();
        this.tipoNoticia = new SimpleObjectProperty<TipoNoticia>();
        this.fecha = new Date();
    }    
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public String getTitulo() {
        return titulo.get();
    }

    public void setTitulo(String titulo) {
        this.titulo.set(titulo);
    }
    
    public StringProperty tituloProperty(){
        return titulo;
    }
    
    public String getContenido() {
        return contenido.get();
    }

    public void setContenido(String contenido) {
        this.contenido.set(contenido);
    }
    
    public StringProperty contenidoProperty(){
        return contenido;
    }

    public Date getFecha() {
        return fecha;
    }

    public TipoNoticia getTipoNoticia() {
        return tipoNoticia.get();
    }

    public void setTipoNoticia(TipoNoticia tipoNoticia) {
        this.tipoNoticia.set(tipoNoticia);
    }
    
    public ObjectProperty<TipoNoticia> tipoNoticiaProperty() {
        return tipoNoticia;
    }

    public Administrador getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }
}
