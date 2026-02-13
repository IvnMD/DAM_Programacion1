package com.docencia.fechas.ejercicio9;

import java.time.Duration;
import java.time.Instant;
import java.util.Objects;

public final class Ejercicio9 {

    private Ejercicio9() {}

    public static boolean canCancelWithin48h(Instant purchase, Instant now) {
    if (purchase == null || now == null){
        throw new NullPointerException();
    }

    Instant cancelacion = purchase.plus(Duration.ofHours(48));

    return !now.isAfter(cancelacion);
}
}
