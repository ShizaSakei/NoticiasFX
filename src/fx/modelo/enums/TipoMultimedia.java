/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fx.modelo.enums;

/**
 *
 * @author PotatoPower
 */
public enum TipoMultimedia {
    IMAGENES("IMAGEN"),
    VIDEO("VIDEO");
    
    String tipo;

    private TipoMultimedia(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
