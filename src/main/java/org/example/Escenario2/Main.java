package org.example.Escenario2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SistemaDeAlmacenamiento instance = SistemaDeAlmacenamiento.getInstance();
        instance.declararProducto();
        boolean flagParada = false;
        while (flagParada) {Scanner sc = new Scanner(System.in);
            System.out.println("Ingrese el codigo del producto: ");
            int codigo = sc.nextInt();
            sc.nextLine();
            if (instance.buscarProducto(codigo) != null){
                String productoDeseado = instance.buscarProducto(codigo);
                System.out.println(productoDeseado);
                System.out.println("desea buscar otro producto? y/n");
                if (!sc.nextLine().equalsIgnoreCase("y")) {
                    flagParada = true;
                }

            }
            else {
                System.out.println("No existe el producto, por favor ingrese un codigo valido");
                System.out.println("desea buscar otro producto? y/n");
                if (!sc.nextLine().equalsIgnoreCase("y")) {
                    flagParada = true;
                }
            }}

    }
}
