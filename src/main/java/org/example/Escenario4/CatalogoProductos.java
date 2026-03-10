package org.example.Escenario4;


import lombok.Data;

import java.util.HashMap;
import java.util.TreeMap;
import java.util.Map;
@Data
public class CatalogoProductos {

    // ─────────────────────────────────────────────
    // FASE 2 — Estructuras seleccionadas
    // HashMap  → búsqueda por código O(1)
    // TreeMap  → visualización ordenada por precio O(log n)
    // ─────────────────────────────────────────────

    // Key: codigo | Value: Producto
    private HashMap<Integer, Producto> catalogoPorCodigo;

    // Key: precio (Double) | Value: Producto
    // Comparator keeps ascending order by price automatically
    private TreeMap<Double, Producto> catalogoPorPrecio;

    // ── Singleton ──
    private static CatalogoProductos instance;

    private CatalogoProductos() {
        this.catalogoPorCodigo = new HashMap<>();
        this.catalogoPorPrecio = new TreeMap<>();
    }

    public static CatalogoProductos getInstance() {
        if (instance == null) {
            instance = new CatalogoProductos();
        }
        return instance;
    }

    // ─────────────────────────────────────────────
    // OPERACIÓN 1 — Insertar producto
    // HashMap:  O(1) average
    // TreeMap:  O(log n)
    // ─────────────────────────────────────────────
    public void insertarProducto(Producto producto) {
        if (catalogoPorCodigo.containsKey(producto.getCodigo())) {
            System.out.println("⚠️  Producto ya existe con código: " + producto.getCodigo());
            return;
        }
        // Insert into both structures simultaneously
        catalogoPorCodigo.put(producto.getCodigo(), producto);
        catalogoPorPrecio.put(producto.getPrecio(), producto);
        System.out.println("✅ Producto insertado: " + producto.getNombre());
    }

    // ─────────────────────────────────────────────
    // OPERACIÓN 2 — Buscar por código
    // HashMap: O(1) — fastest possible lookup
    // ─────────────────────────────────────────────
    public Producto buscarPorCodigo(int codigo) {
        Producto resultado = catalogoPorCodigo.getOrDefault(codigo, null);
        if (resultado == null) {
            System.out.println("❌ Producto no encontrado con código: " + codigo);
        }
        return resultado;
    }

    // ─────────────────────────────────────────────
    // OPERACIÓN 3 — Mostrar ordenados por precio ascendente
    // TreeMap: O(n) to iterate, already sorted O(log n) on insert
    // ─────────────────────────────────────────────
    public void mostrarPorPrecioAscendente() {
        System.out.println("\n📋 Productos — Precio Ascendente:");
        System.out.println("─".repeat(65));
        catalogoPorPrecio.forEach((precio, producto) ->
                System.out.println(producto)
        );
    }

    // ─────────────────────────────────────────────
    // OPERACIÓN 4 — Mostrar ordenados por precio descendente
    // TreeMap.descendingMap(): O(1) — just reverses the view
    // ─────────────────────────────────────────────
    public void mostrarPorPrecioDescendente() {
        System.out.println("\n📋 Productos — Precio Descendente:");
        System.out.println("─".repeat(65));
        catalogoPorPrecio.descendingMap().forEach((precio, producto) ->
                System.out.println(producto)
        );
    }

    // ─────────────────────────────────────────────
    // OPERACIÓN 5 — Eliminar producto
    // HashMap: O(1) | TreeMap: O(log n)
    // ─────────────────────────────────────────────
    public void eliminarProducto(int codigo) {
        Producto producto = catalogoPorCodigo.remove(codigo);
        if (producto != null) {
            catalogoPorPrecio.remove(producto.getPrecio());
            System.out.println("🗑️  Producto eliminado: " + producto.getNombre());
        } else {
            System.out.println("❌ No se encontró producto con código: " + codigo);
        }
    }

    // ─────────────────────────────────────────────
    // OPERACIÓN 6 — Mostrar todos (sin orden específico)
    // HashMap: O(n)
    // ─────────────────────────────────────────────
    public void mostrarTodos() {
        System.out.println("\n📦 Todos los productos (" + catalogoPorCodigo.size() + " total):");
        System.out.println("─".repeat(65));
        catalogoPorCodigo.forEach((codigo, producto) ->
                System.out.println(producto)
        );
    }

    public int totalProductos() {
        return catalogoPorCodigo.size();
    }
}