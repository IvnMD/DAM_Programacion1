package com.docencia.clases.ejercicio3;

import java.time.LocalDate;
import java.util.regex.Pattern;

public class Factura {

    private final String numeroFactura;
    private final String iban;
    private final String nifEmpresa;
    private final LocalDate fechaEmision;
    private final LocalDate fechaVencimiento;

    public Factura(String numeroFactura, String iban, String nifEmpresa, LocalDate fechaEmision,
            LocalDate fechaVencimiento) {
        this.numeroFactura = numeroFactura;
        this.iban = iban;
        this.nifEmpresa = nifEmpresa;
        this.fechaEmision = fechaEmision;
        this.fechaVencimiento = fechaVencimiento;
    }

    public void validate() {
        if (numeroFactura == null || iban == null || nifEmpresa == null ||
                fechaEmision == null || fechaVencimiento == null) {
            throw new IllegalArgumentException();
        }

        // Formato FAC-YYYY-6DÍGITOS
        if (!Pattern.matches("^FAC-\\d{4}-\\d{6}$", numeroFactura)) {
            throw new IllegalArgumentException();
        }

        // Formato ES + 22 dígitos
        if (!Pattern.matches("^ES\\d{22}$", iban)) {
            throw new IllegalArgumentException();
        }

        // NIF Empresa: Letra inicial (A-J, P, Q, R, S, U, V, N, W) + 7 u 8 dígitos +
        // letra/dígito
        // El test rechaza específicamente un DNI (8 números + letra)
        if (!Pattern.matches("^[A-Z][0-9]{7,8}[A-Z0-9]$", nifEmpresa)
                || Pattern.matches("^[0-9]{8}[A-Z]$", nifEmpresa)) {
            throw new IllegalArgumentException();
        }

        if (fechaVencimiento.isBefore(fechaEmision)) {
            throw new IllegalArgumentException();
        }
    }

    public boolean isVencida(LocalDate hoy) {
        if (hoy == null)
            throw new IllegalArgumentException();
        return hoy.isAfter(fechaVencimiento);
    }

    public String getNumeroFactura() {
        return numeroFactura;
    }

    public String getIban() {
        return iban;
    }

    public String getNifEmpresa() {
        return nifEmpresa;
    }

    public LocalDate getFechaEmision() {
        return fechaEmision;
    }

    public LocalDate getFechaVencimiento() {
        return fechaVencimiento;
    }
}