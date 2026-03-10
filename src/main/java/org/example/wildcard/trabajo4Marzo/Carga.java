package org.example.wildcard.trabajo4Marzo;

import lombok.Data;

import java.util.List;

@Data
public class Carga {

    private List<?> productos;
    private String destination;
    private TIPODATO tipoDato;

    public Carga(List<?> productos, String destination, TIPODATO tipoDato) {
        this.productos = productos;
        this.destination = destination;
        this.tipoDato = tipoDato;
    }
}
