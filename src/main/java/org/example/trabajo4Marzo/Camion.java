package org.example.trabajo4Marzo;

import lombok.Data;

import java.io.Serializable;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;

@Data
public class Camion implements Iterable<Producto> {

    private Carga carga;


    public Camion(Carga carga) {
        this.carga = carga;

    }
    public void Cargar(List<Producto> productos, String destination, TIPODATO tipoDato) {
        carga = new Carga(productos, destination, tipoDato);
        System.out.println("carga: " + carga.toString());
    }

    public void Descargar(){
        if (carga == null) {
            System.out.println("no hay carga que descargar");
        }
        else {
            carga = null;
            System.out.println("Descargando");
        }
    }

    @Override
    public void forEach(Consumer<? super Producto> action) {
        if (action == null) throw new NullPointerException();
        if (carga == null) return; // no crash if truck is empty

        carga.forEach(action); // delegates to Carga's forEach
    }

    @Override
    public Spliterator spliterator() {
        return Iterable.super.spliterator();
    }

    @Override
    public Iterator<Producto> iterator() {
        return carga; // ← Carga itself is already an Iterator!
    }
}
