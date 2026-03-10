package org.example.tallerPreparcial;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        LinkedList<Operador> listaOperadores = new LinkedList<Operador>();
        SistemaGestionTareas.getInstancia(new PriorityQueue<TareaGenerica>(),listaOperadores ).crearOperadores();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bienvendio a el gestor de tareas");
        System.out.println("Que tarea desea ejecutar, por favor especifique cual operador usar:");
        String opcion = scanner.nextLine();
        System.out.println("Ingrese el ");

    }


}
