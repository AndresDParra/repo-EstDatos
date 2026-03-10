package org.example.Escenario4;

import lombok.Data;

@Data
public class Producto {

    private int codigo;
    private String nombre;
    private String descripcion;
    private double precio;
    private int stock;

    public Producto(int codigo, String nombre, String descripcion, double precio, int stock) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.stock = stock;
    }

    public int getCodigo()           { return codigo; }
    public String getNombre()        { return nombre; }
    public String getDescripcion()   { return descripcion; }
    public double getPrecio()        { return precio; }
    public int getStock()            { return stock; }


    @Override
    public String toString() {
        return String.format(
                "[%d] %-20s | $%-8.2f | Stock: %d | %s",
                codigo, nombre, precio, stock, descripcion
        );
    }
}
