package org.example.wildcard.trabajo4Marzo;

import lombok.Data;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

@Data
public class Producto implements Comparable<Producto> {

    private String nombre;
    private int precio;

    public Producto(String nombre, int precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public static List<Producto> crearProducto(int numeroProductos){
        List<Producto> productos = new LinkedList<Producto>();
        try {
            int i = 0;
            while (i < numeroProductos) {

                Scanner sc = new Scanner(System.in);
                System.out.println("Ingrese el nombre del producto");
                String nombreProducto = sc.nextLine();
                System.out.println("Ingrese el precio del producto");
                int precioProducto = sc.nextInt();
                Producto p = new Producto(nombreProducto, precioProducto);

                productos.add(p);
                i++;
            }
        } catch (Exception e) {
            if (e instanceof IllegalArgumentException) {
                System.out.println("Error al intentar ingresar los datos, ");
            }
        }

        return productos;
    }

    @Override
    public int compareTo(Producto producto1) {
        producto1.getNombre().compareTo(this.getNombre());
        return 0;
    }
}
