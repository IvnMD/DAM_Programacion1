package com.docencia.interfaces.ejercicio7;

import java.util.Objects;
import java.util.UUID;

/**
 * Implementacion concreta de Exportable.
 */
public class JsonExporter implements Exportable {

    private UUID id;
    private boolean pretty;
    private int indent;

    public JsonExporter(UUID id, boolean pretty, int indent) {
        this.id = id == null ? UUID.randomUUID() : id;
        this.pretty = pretty;
        this.indent = indent;
    }

    public UUID getId() {
        return id;
    }

    public boolean getPretty() {
        return pretty;
    }

    public int getIndent() {
        return indent;
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
        JsonExporter other = (JsonExporter) obj;
        return Objects.equals(id, other.id);
    }

    @Override
    public String toString() {
        return "JsonExporter [id=" + id + ", pretty=" + pretty + ", indent=" + indent + "]";
    }

}
