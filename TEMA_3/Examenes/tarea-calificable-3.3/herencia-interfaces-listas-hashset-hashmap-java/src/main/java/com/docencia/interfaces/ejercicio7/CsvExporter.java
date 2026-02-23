package com.docencia.interfaces.ejercicio7;

import java.util.Objects;
import java.util.UUID;

/**
 * Implementacion concreta de Exportable.
 */
public class CsvExporter implements Exportable {

    private UUID id;
    private String separador;
    private int columnas;

    public CsvExporter(UUID id, String separador, int columnas) { 
        this.id = id == null ? UUID.randomUUID() : id;
        this.separador = separador;
        this.columnas = columnas;
    }

    public UUID getId() { return id; }
    public String getSeparador() { return separador; }
    public int getColumnas() { return columnas; }

    @Override
    public String exportar() {
        return "CSV(" + columnas + ")";
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        CsvExporter other = (CsvExporter) obj;
        return Objects.equals(id, other.id);
    }

    @Override
    public String toString() {
        return "CsvExporter [id=" + id + ", separador=" + separador + ", columnas=" + columnas + "]";
    }

    
}
