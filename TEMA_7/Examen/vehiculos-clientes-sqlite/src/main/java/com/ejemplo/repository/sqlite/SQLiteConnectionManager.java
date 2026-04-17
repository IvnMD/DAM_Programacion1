package com.ejemplo.repository.sqlite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLiteConnectionManager {

    public static String rutaDb = "src/main/resources/data/sqlite/vehiculos.db";


    public SQLiteConnectionManager(String rutaDb) {
        this.rutaDb = rutaDb;
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:sqlite:" + rutaDb);
    }

    public void closeConnection(Connection connection) {
                try {
            if (connection != null) {
                if (!connection.isClosed()) {
                    connection.close();
                }
            }
        } catch (Exception e) {
            System.err.println("Se ha producido un error cerrando la conexion");
        }
    }
}

