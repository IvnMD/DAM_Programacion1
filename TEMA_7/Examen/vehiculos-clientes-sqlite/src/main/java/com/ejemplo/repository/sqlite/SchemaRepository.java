package com.ejemplo.repository.sqlite;

import java.sql.Connection;
import java.sql.Statement;

public class SchemaRepository extends SQLiteConnectionManager {

    public SchemaRepository(String rutaDb) {
        super(rutaDb);
    }

    public void createSchema() {
        Connection connection = null;
        try {
            connection = getConnection();
            try (Statement statement = connection.createStatement()) {
                statement.executeUpdate("""
                    CREATE TABLE IF NOT EXISTS cliente (
                        dni TEXT PRIMARY KEY,
                        nombre TEXT NOT NULL,
                        email TEXT,
                        telefono TEXT,
                        ciudad TEXT,
                        activo INTEGER NOT NULL DEFAULT 1
                    )
                """);
                statement.executeUpdate("""
                    CREATE TABLE IF NOT EXISTS vehiculo (
                        id INTEGER PRIMARY KEY AUTOINCREMENT,
                        matricula TEXT NOT NULL UNIQUE,
                        marca TEXT NOT NULL,
                        modelo TEXT NOT NULL,
                        color TEXT,
                        anio INTEGER,
                        kilometros INTEGER NOT NULL DEFAULT 0,
                        precio REAL NOT NULL,
                        vendido INTEGER NOT NULL DEFAULT 0,
                        dni_cliente TEXT NOT NULL,
                        FOREIGN KEY (dni_cliente) REFERENCES cliente(dni)
                    )
                """);
            }
        } catch (Exception e) {
            throw new RuntimeException("No se pudo crear el esquema", e);
        } finally {
            closeConnection(connection);
        }
    }
}
