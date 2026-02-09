package com.docencia.app;

import java.util.stream.Stream;

public class Empleado extends Persona{

    private Direccion direccion;
    private CuentaBancaria CuentaBancaria;

    public Empleado(){
        super();
    }

    public Empleado(Direccion direccion) {
        this.direccion = direccion;
    }

    public Empleado(String identificador, Direccion direccion) {
        super(identificador);
        this.direccion = direccion;
    }

    public Empleado(String identificador, String nombre, int edad, Direccion direccion) {
        super(identificador, nombre, edad);
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Empleado [" + super.toString()+ " direccion = " + direccion + ", CuentaBancaria=" + CuentaBancaria + "]";
    }

    public static void main(String[] args){
        String indentificador = "99999999R";
        String nombre = "Juan España";
        int edad = 99;
        Direccion direccion = new Direccion("Una Calle", 38260, "Tejina", 1000);
        Empleado empleado = new Empleado(indentificador, nombre, edad, direccion);
        System.out.println(empleado);
    }
    

    

}
