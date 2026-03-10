package org.example.tallerPreparcial;

import lombok.Data;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

@Data
public class SistemaGestionTareas {

    private Queue<TareaGenerica> tareas;
    private List<Operador> operadores;

    private static SistemaGestionTareas instancia;

    public SistemaGestionTareas(PriorityQueue<TareaGenerica> tareas, List<Operador> operadores) {
        this.tareas = tareas;
        this.operadores = operadores;
    }
    public static SistemaGestionTareas getInstancia(PriorityQueue<TareaGenerica> tareas, List<Operador> operadores) {
        if (instancia == null) {
            instancia = new SistemaGestionTareas(tareas, operadores);
        }
        return instancia;
    }

    public void crearOperadores() {
        Operador operador = new Operador("Juan", 23, "23456", LocalTime.of(9, 0) , LocalTime.of(16, 0), "a2s3d4");
        operadores.add(operador);
        Operador operador2 = new Operador("Pedro", 33, "24443456", LocalTime.of(9, 0) , LocalTime.of(16, 0), "s2d3f4g5");
        operadores.add(operador2);
    }
}
