/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fx.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author PotatoPower
 */
@Getter
@Setter
public class Administrador implements Serializable{
    private Long id;
    private String apellidos, nombres, usuario, clave;
    private List<Noticia> listNoticia = new ArrayList<>();
}
