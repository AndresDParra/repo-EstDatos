package org.example.tallerPreparcial;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;
import java.time.LocalTime;

@EqualsAndHashCode(callSuper = true)
@Data
public class Operador extends Persona{

    private String IDTrabajador;
    private LocalTime horaInicioTurno;
    private LocalTime horaFinTurno;

    public Operador(String nombre, int edad, String ID, LocalTime horaInicioTurno, LocalTime horaFinTurno, String IDTrabajador) {
        super(nombre, edad, ID);
        this.IDTrabajador = IDTrabajador;
        this.horaInicioTurno = horaInicioTurno;
        this.horaFinTurno = horaFinTurno;
    }




}
