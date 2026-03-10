package org.example.Escenario2;

import lombok.Data;

import java.util.Comparator;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

@Data
public class Producto implements Comparator<Producto> {

    private int codigo;
    private String nombre;
    private int precio;

    public Producto(int codigo, String nombre,  int precio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
    }

    @Override
    public int compare(Producto o1, Producto o2) {
        if (o1.getPrecio() > o2.getPrecio()) {
            return 1;
        }
        else if (o1.getPrecio() < o2.getPrecio()) {
            return -1;
        }
        return 0;
    }

}
