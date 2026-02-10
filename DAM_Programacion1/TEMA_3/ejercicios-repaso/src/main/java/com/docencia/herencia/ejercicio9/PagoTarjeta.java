package com.docencia.herencia.ejercicio9;

import java.util.List;

public class PagoTarjeta extends Pago {
        private final double recargoPorcentaje;

        public PagoTarjeta(double importeBase, double recargoPorcentaje) {
            super(importeBase);
            this.recargoPorcentaje = recargoPorcentaje;
        }

        @Override
        public double calcularImporteFinal() {
            double resultado = getImporteBase() + (getImporteBase() * recargoPorcentaje / 100);
                if (resultado <= 0.0){
                    return 0.0;
                }
            return resultado;
        }
    

    public static double totalPagos(List<Pago> pagos) {
        if (pagos == null || pagos.isEmpty()) {
            return 0.0;
        }
    
        double total = 0.0;
        for (Pago pago : pagos) {
            if (pago != null) {
                total += pago.calcularImporteFinal();
            }
        }
        return total;
    }

}

