package org.example.wildcard.trabajo4Marzo;

import lombok.Data;
import org.example.trabajo4Marzo.Producto;

import java.util.*;
import java.util.function.Consumer;

@Data
public class Camion implements Iterable {

    private Carga carga;


    public Camion(Carga carga) {
        this.carga = carga;

    }
    public void Cargar(List<?> productos, String destination, TIPODATO tipoDato) {
        carga = new Carga(productos, destination, tipoDato);
        System.out.println("carga: " + carga.toString());
    }
    public static List<? super Producto> crearProducto(int numeroProductos){
        List<? super Producto> productos = new LinkedList<Producto>();
        try {
            int i = 0;
            while (i < numeroProductos) {

                Scanner sc = new Scanner(System.in);
                System.out.println("Ingrese el nombre del producto");
                String nombreProducto = sc.nextLine();
                System.out.println("Ingrese el precio del producto");
                int precioProducto = sc.nextInt();
                Producto producto = new Producto(nombreProducto, precioProducto);

                productos.add(producto);
                i++;
            }
        } catch (Exception e) {
            if (e instanceof IllegalArgumentException) {
                System.out.println("Error al intentar ingresar los datos, ");
            }
        }

        return productos;
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
    public Iterator iterator() {
        // Si no hay carga, retorna un iterador vacío
        if (carga == null || carga.getProductos() == null) {
            return Collections.emptyIterator();
        }
        return carga.getProductos().iterator();
    }

    @Override
    public void forEach(Consumer action) {
        Iterable.super.forEach(action);
    }

    @Override
    public Spliterator spliterator() {
        return Iterable.super.spliterator();
    }
}
