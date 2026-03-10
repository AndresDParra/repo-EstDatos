package org.example.Escenario4;


public class Main {

    public static void main(String[] args) {

        CatalogoProductos catalogo = CatalogoProductos.getInstance();

        // ─────────────────────────────────────────
        // INSERTAR productos — O(1) HashMap / O(log n) TreeMap
        // ─────────────────────────────────────────
        System.out.println("═".repeat(65));
        System.out.println("           ESCENARIO 4 — CATÁLOGO E-COMMERCE");
        System.out.println("═".repeat(65));

        catalogo.insertarProducto(new Producto(1001, "Laptop Pro",       "Intel i7 16GB RAM",    1299.99, 50));
        catalogo.insertarProducto(new Producto(1002, "Mouse Inalámbrico","Logitech MX Master 3",   89.99, 200));
        catalogo.insertarProducto(new Producto(1003, "Monitor 4K",       "LG 27 pulgadas",        499.99, 75));
        catalogo.insertarProducto(new Producto(1004, "Teclado Mecánico", "Switch Blue Cherry MX",  149.99, 120));
        catalogo.insertarProducto(new Producto(1005, "Auriculares BT",   "Sony WH-1000XM5",        349.99, 90));
        catalogo.insertarProducto(new Producto(1006, "Webcam HD",        "Logitech C920",           79.99, 180));
        catalogo.insertarProducto(new Producto(1007, "SSD 1TB",          "Samsung 980 Pro NVMe",   129.99, 300));

        // ─────────────────────────────────────────
        // BUSCAR por código — O(1)
        // ─────────────────────────────────────────
        System.out.println("\n🔍 Búsqueda por código (O(1)):");
        System.out.println("─".repeat(65));

        Producto encontrado = catalogo.buscarPorCodigo(1003);
        if (encontrado != null) {
            System.out.println("Encontrado → " + encontrado);
        }

        catalogo.buscarPorCodigo(9999); // not found case

        // ─────────────────────────────────────────
        // MOSTRAR ordenado por precio — TreeMap O(n)
        // ─────────────────────────────────────────
        catalogo.mostrarPorPrecioAscendente();
        catalogo.mostrarPorPrecioDescendente();

        // ─────────────────────────────────────────
        // ELIMINAR producto — O(1) + O(log n)
        // ─────────────────────────────────────────
        System.out.println("\n🗑️  Eliminando producto 1006...");
        catalogo.eliminarProducto(1006);
        catalogo.eliminarProducto(9999); // not found case

        // ─────────────────────────────────────────
        // MOSTRAR todos después de eliminar
        // ─────────────────────────────────────────
        catalogo.mostrarTodos();

        // ─────────────────────────────────────────
        // RESUMEN de complejidades
        // ─────────────────────────────────────────
        System.out.println("\n" + "═".repeat(65));
        System.out.println("           RESUMEN DE COMPLEJIDADES");
        System.out.println("═".repeat(65));
        System.out.printf("%-30s %-15s %-10s%n", "Operación", "Estructura", "Tiempo");
        System.out.println("─".repeat(65));
        System.out.printf("%-30s %-15s %-10s%n", "Buscar por código",        "HashMap",  "O(1)");
        System.out.printf("%-30s %-15s %-10s%n", "Insertar producto",        "HashMap",  "O(1)");
        System.out.printf("%-30s %-15s %-10s%n", "Insertar en orden precio", "TreeMap",  "O(log n)");
        System.out.printf("%-30s %-15s %-10s%n", "Mostrar por precio",       "TreeMap",  "O(n)");
        System.out.printf("%-30s %-15s %-10s%n", "Eliminar producto",        "HashMap",  "O(1)");
        System.out.println("═".repeat(65));
        System.out.println("Total productos en catálogo: " + catalogo.totalProductos());
    }
}