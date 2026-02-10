package com.docencia.herencia.ejercicio9;

public class PagoEfectivo extends Pago {


        public PagoEfectivo(double importeBase) {
            super(importeBase);
        }

        @Override
        public double calcularImporteFinal() {
            double resultado = getImporteBase();
            return Math.max(resultado,0.0);
        }
    }
