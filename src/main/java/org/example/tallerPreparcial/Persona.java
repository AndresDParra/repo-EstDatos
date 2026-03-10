package org.example.tallerPreparcial;

import lombok.Data;

@Data
public class Persona {

     private  String nombre;
     private int edad;
     private String ID;


    public Persona(String nombre, int edad, String ID) {
        this.nombre = nombre;
        this.edad = edad;
        this.ID = ID;
    }
    public Persona() {
    }
}
