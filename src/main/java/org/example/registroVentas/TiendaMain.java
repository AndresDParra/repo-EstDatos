package org.example.registroVentas;

import lombok.Data;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

@Data
public class TiendaMain {

    private LinkedHashMap<String,venta> ventas;
    private ArrayList<Producto> productos;
    public TiendaMain(){
        ventas = new LinkedHashMap<>();
        this.productos = new ArrayList<>();
    }

    public LinkedHashMap<String, venta> getVentas() {
        return ventas;
    }

    public void setVentas(LinkedHashMap<String, venta> ventas) {
        this.ventas = ventas;
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<Producto> productos) {
        this.productos = productos;
    }

    public  void consultarProducto(String codigo) {

        venta venta = ventas.get(codigo);

        if (venta != null) {
            System.out.println("Producto encontrado:");
            System.out.println(venta);
        } else {
            System.out.println("No existe una venta con ese código.");
        }
    }

    public void mostrarTodasLasVentas() {

        if (ventas.isEmpty()) {
            System.out.println("No hay ventas registradas.");
            return;
        }

        System.out.println("Ventas registradas (HashMap - sin orden específico):");

        for (Map.Entry<String, venta> entrada : ventas.entrySet()) {
            System.out.println(entrada.getValue());
        }
    }

    public void mostrarVentasEnOrdenDeRegistro() {

        if (ventas.isEmpty()) {
            System.out.println("No hay ventas registradas.");
            return;
        }

        System.out.println("Ventas en orden de registro (LinkedHashMap):");

        for (Map.Entry<String, venta> entrada : ventas.entrySet()) {
            System.out.println(entrada.getValue());
        }
    }

    public static void main(String[] args) {
        TiendaMain tiendaMain = new TiendaMain();
        System.out.println("Iniciando...guardado de ventas, bienvenido si o q");
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el codigo del producto");
        String codproducto = sc.nextLine();
        System.out.println("Ingrese el precio del producto");
        String precio = sc.nextLine();
        System.out.println("Ingrese cantidad del producto");
        String cantidad = sc.nextLine();
        System.out.println("Ingrese su nombre");
        String nombre = sc.nextLine();
        System.out.println("Ingrese su ID");
        String id = sc.nextLine();
        System.out.println("Ingrese su edad");
        int edad = sc.nextInt();
        cliente cliente = new cliente(nombre,id,edad);

       Producto producto1 = Producto.crearProducto(codproducto, Integer.parseInt(precio), Integer.parseInt(cantidad));
//       Producto producto2 = Producto.crearProducto(codproducto +"9", Integer.parseInt(precio)*2 , Integer.parseInt(cantidad)*2);
//       Producto producto3 = Producto.crearProducto(codproducto+"2", Integer.parseInt(precio)*3, Integer.parseInt(cantidad)*3);
       tiendaMain.getProductos().add(producto1);
//       tiendaMain.getProductos().add(producto2);
//       tiendaMain.getProductos().add(producto3);
       venta nuevaVenta = venta.registrarVenta(producto1, Integer.parseInt(cantidad), cliente);
//       venta nuevaVenta2 = venta.registrarVenta(producto2, Integer.parseInt(cantidad), cliente);
//       venta nuevaVenta3 = venta.registrarVenta(producto3, Integer.parseInt(cantidad), cliente);
       tiendaMain.getVentas().put(producto1.getCodproducto(),nuevaVenta);
       System.out.println("deseas ingresar más productos y/n");
       String respuesta = sc.nextLine();
//       tiendaMain.getVentas().put(producto2.getCodproducto(),nuevaVenta2);
//       tiendaMain.getVentas().put(producto3.getCodproducto(),nuevaVenta3);
       tiendaMain.mostrarTodasLasVentas();
       tiendaMain.mostrarVentasEnOrdenDeRegistro();


    }
}
