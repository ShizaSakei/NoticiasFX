/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fx.modelo;

import java.io.Serializable;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author PotatoPower
 */
@Getter
@Setter
public class Comentario implements Serializable {
    private Long id;
    private String alias, texto;
    private Date fecha;
    private Noticia noticia;
}
