package com.ejemplo.support;

import com.ejemplo.model.Cliente;
import com.ejemplo.model.Vehiculo;

public class TestDataFactory {

    public static Cliente cliente1() {
        return new Cliente("11111111A", "Ana", "ana@demo.com", "600111111", "Madrid", true);
    }

    public static Cliente cliente2() {
        return new Cliente("22222222B", "Luis", "luis@demo.com", "600222222", "Sevilla", true);
    }

    public static Cliente cliente3Inactivo() {
        return new Cliente("33333333C", "Marta", "marta@demo.com", "600333333", "Madrid", false);
    }

    public static Vehiculo vehiculo1(String dni) {
        return new Vehiculo(null, "1111BBB", "Seat", "Ibiza", "Rojo", 2020, 25000, 12500.0, false, dni);
    }

    public static Vehiculo vehiculo2(String dni) {
        return new Vehiculo(null, "2222CCC", "Renault", "Clio", "Azul", 2019, 40000, 9800.0, false, dni);
    }

    public static Vehiculo vehiculo3Vendido(String dni) {
        return new Vehiculo(null, "3333DDD", "Ford", "Focus", "Negro", 2018, 60000, 8700.0, true, dni);
    }
}
