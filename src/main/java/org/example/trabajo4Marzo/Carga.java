package org.example.trabajo4Marzo;

import lombok.Data;
import org.example.registroVentas.TiendaMain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

@Data
public class Carga implements Iterator<Producto> {

    private List<Producto> productos;
    private String destination;
    private TIPODATO tipoDato;
    private int indice = 0;

    public Carga(List<Producto> productos, String destination, TIPODATO tipoDato) {
        this.productos = productos;
        this.destination = destination;
        this.tipoDato = tipoDato;
    }

    @Override
    public boolean hasNext() {
        return productos != null && indice < productos.size();
    }

    @Override
    public Producto next() {
        if (!hasNext()) throw new NoSuchElementException();

        Producto elemento = productos.get(indice);
        indice += 2; // skips to next even index
        return elemento;
    }



}