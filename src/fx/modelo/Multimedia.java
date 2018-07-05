/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fx.modelo;

import fx.modelo.enums.TipoMultimedia;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author PotatoPower
 */
@Getter
@Setter
public class Multimedia implements Serializable{
    private Long id;
    private String ubicacion;
    private TipoMultimedia tipo;
    private boolean portada;
    private Noticia noticia;
}
