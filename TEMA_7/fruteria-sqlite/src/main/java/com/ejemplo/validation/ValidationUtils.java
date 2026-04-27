package com.ejemplo.validation;

import com.ejemplo.model.*;

public final class ValidationUtils {
    static String dniPatron = "^[\\d]{8}[A-Z]$";
    static String cifPatron = "^[A-Z][\\d]{8}$";
    static String tlfPatron = "[0-9]{9}";
    static String emailPatron = "[a-zA-Z0-9_]+([.][a-zA-Z0-9_]+)*@[a-zA-Z0-9_]+([.][a-zA-Z0-9_]+)*[.][a-zA-Z]{2,5}";
    static String nombrePatron = "^([A-ZÁÉÍÓÚÑ]{1}[a-záéíóúñ]+$|^[A-ZÁÉÍÓÚÑ]{1}[a-záéíóúñ]+ [A-ZÁÉÍÓÚÑ]{1}[a-záéíóúñ]+$)";
    static String ciudadPatron = "^([A-Z][a-z]+|[A-Z][a-z]+ [A-Z][a-z]+)$";
    static String codigoPatron = "^[A-Z]{3}-[A-Z]{3}-[0-9]{3}$";
    static String fechaPatron = "^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01]) (0[0-9]|1[0-9]|2[0-3]):[0-5][0-9]:[0-5][0-9]$";
    static String facPatron = "^FAC-[0-9]{4}-[0-9]{3}$";
    static String ticPatron = "^TCK-[0-9]{4}-[0-9]{3}$";

    private ValidationUtils() {
    }

    public static boolean isBlank(String value) {
        return value == null || value.isBlank();
    }

    public static boolean isValidDni(String dni) {
        return dni != null && !isBlank(dni) && dni.matches(dniPatron);
    }

    // public static boolean isValidOptionalDni(String dni) {
    //     return dni != null && isBlank(dni) || dni.matches(dniPatron);
    // }

    public static boolean isValidCif(String cif) {
        return cif != null && !isBlank(cif) && cif.matches(cifPatron);
    }

    public static boolean isValidTelefono(String telefono) {
        return isBlank(telefono) || telefono.matches(tlfPatron);
    }

    public static boolean isValidEmail(String email) {
        return isBlank(email) || email.matches(emailPatron);
    }

    public static boolean isValidNombre(String nombre) {
        return nombre != null && !isBlank(nombre) && nombre.matches(nombrePatron);
    }

    public static boolean isValidCiudad(String ciudad) {
        return ciudad == null  ||  ciudad.matches(ciudadPatron);
    }

    public static boolean isValidCodigoProducto(String codigo) {
        return codigo != null && !isBlank(codigo) && codigo.matches(codigoPatron);
    }

    public static boolean isValidFechaHora(String fecha) {
        return fecha != null && !isBlank(fecha) && fecha.matches(fechaPatron);
    }

    public static boolean isValidFactura(String factura) {
        return factura != null && !isBlank(factura) && factura.matches(facPatron);
    }

    public static boolean isValidTicket(String ticket) {
        return ticket != null && !isBlank(ticket) && ticket.matches(ticPatron);
    }

    public static boolean isPositive(Integer value) {
        return value != null && value >= 1;
    }

    public static boolean isNonNegative(Double value) {
        return value != null && value >= 0;
    }

    public static boolean isPositive(Double value) {
        return value != null && value >= 1;
    }

    public static boolean isBooleanInteger(Integer value) {
        return value != null && value == 1;
    }

    public static boolean isValidCliente(Cliente cliente) {
        if (cliente == null)
            return false;
        return isValidDni(cliente.getDni())
                && isValidNombre(cliente.getNombre())
                && isValidCiudad(cliente.getCiudad());
    }

    public static boolean isValidProveedor(Proveedor proveedor) {
        if (proveedor == null)
            return false;
        return isValidCif(proveedor.getCif())
                && isValidNombre(proveedor.getNombre())
                && isValidCiudad(proveedor.getCiudad());
    }

    public static boolean isValidProducto(Producto producto) {
        if (producto == null)
            return false;
        return isValidCodigoProducto(producto.getCodigo())
                && isValidNombre(producto.getNombre())
                && isValidCif(producto.getCifProveedorPrincipal());
    }

    public static boolean isValidCompra(Compra compra) {
        if (compra == null)
            return false;
        return isValidFechaHora(compra.getFecha())
                && isValidFactura(compra.getNumeroFactura())
                && isValidCif(compra.getCifProveedor());
    }

    public static boolean isValidVenta(Venta venta) {
        if (venta == null)
            return false;
        return isValidFechaHora(venta.getFecha())
                && isValidTicket(venta.getTicket())
                && (venta.getDniCliente() == null || isValidDni(venta.getDniCliente())); // DNI opcional
    }
}