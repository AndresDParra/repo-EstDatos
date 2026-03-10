package org.example.Escenario2;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

@Data
public class SistemaDeAlmacenamiento {

    private static SistemaDeAlmacenamiento instance;
    private HashMap<Producto, String> listaProductos;

    public SistemaDeAlmacenamiento(HashMap<Producto, String> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public static SistemaDeAlmacenamiento getInstance() {
        if (instance == null) {
            instance = new SistemaDeAlmacenamiento(new HashMap<>());
        }
        return instance;
    }

    public String buscarProducto(int codigo) {
        return listaProductos.get(String.valueOf(codigo));
    }

    public void declararProducto() {
        Producto producto1 = new Producto(1, "lavadora", 10);
        Producto producto2 = new Producto(2, "Televisor", 23);
        Producto producto3 = new Producto(3, "Fernely", 45);
        Producto producto4 = new Producto(4, "Iphone", 45);

        listaProductos.put(producto1, producto1.toString());
        listaProductos.put(producto2, producto2.toString());
        listaProductos.put(producto3, producto3.toString());
        listaProductos.put(producto4, producto4.toString());


    }

    public List<Producto> mayorPrecio(List<Producto> productos) {
        List<Producto> listaProductos = new LinkedList<Producto>();
        productos.forEach(producto -> {
            if (producto.getPrecio() > producto.getPrecio()) {
                listaProductos.add(producto);
            }
        });
        return listaProductos;
    }
    public void agregarProducto(int codigo, String nombre, int precio) {
        Producto producto = new Producto(codigo, nombre, precio);
        listaProductos.put(producto, producto.toString());
    }

}