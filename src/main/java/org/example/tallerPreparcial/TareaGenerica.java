package org.example.tallerPreparcial;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

@Data
public class TareaGenerica implements Comparator<TareaGenerica> {

    private Operador operador;
    private LocalDateTime fechaVencimiento;
    private int prioridad;

    public TareaGenerica(Operador operador, LocalDateTime fechaVencimiento, int prioridad) {
        this.operador = operador;
        this.fechaVencimiento = fechaVencimiento;
        this.prioridad = prioridad;
    }

    @Override
    public int compare(TareaGenerica t1, TareaGenerica t2) {
        if (t1.fechaVencimiento == null && t2.fechaVencimiento == null) return 0;
        if (t1.fechaVencimiento == null) return 1;  // null goes last
        if (t2.fechaVencimiento == null) return -1;

        return t1.fechaVencimiento.compareTo(t2.fechaVencimiento);
    }

    @Override
    public Comparator<TareaGenerica> reversed() {
        return Comparator.super.reversed();
    }

    @Override
    public Comparator<TareaGenerica> thenComparing(Comparator<? super TareaGenerica> other) {
        return Comparator.super.thenComparing(other);
    }

    @Override
    public <U> Comparator<TareaGenerica> thenComparing(Function<? super TareaGenerica, ? extends U> keyExtractor, Comparator<? super U> keyComparator) {
        return Comparator.super.thenComparing(keyExtractor, keyComparator);
    }

    @Override
    public <U extends Comparable<? super U>> Comparator<TareaGenerica> thenComparing(Function<? super TareaGenerica, ? extends U> keyExtractor) {
        return Comparator.super.thenComparing(keyExtractor);
    }

    @Override
    public Comparator<TareaGenerica> thenComparingInt(ToIntFunction<? super TareaGenerica> keyExtractor) {
        return Comparator.super.thenComparingInt(keyExtractor);
    }

    @Override
    public Comparator<TareaGenerica> thenComparingLong(ToLongFunction<? super TareaGenerica> keyExtractor) {
        return Comparator.super.thenComparingLong(keyExtractor);
    }

    @Override
    public Comparator<TareaGenerica> thenComparingDouble(ToDoubleFunction<? super TareaGenerica> keyExtractor) {
        return Comparator.super.thenComparingDouble(keyExtractor);
    }
}
