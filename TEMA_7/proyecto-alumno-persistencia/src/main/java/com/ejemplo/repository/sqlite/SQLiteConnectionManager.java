package com.ejemplo.repository.sqlite;

import java.io.File;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public abstract class SQLiteConnectionManager {

    public static String rutaDB = "src/main/resources/data/sqlite/demo.db";

    private String url;

    SQLiteConnectionManager(String rutaDB) {
        try {
            File file = new File(rutaDB);
            if (!file.exists()) {
                Path path = Path.of(rutaDB);

                file.createNewFile();
                // inicializar la bbd
            }
            this.url = rutaDB;
        } catch (Exception e) {
            // TODO: handle exception
        }

        this.url = "jdbc:sqlite:" + rutaDB;

    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url);
    }

    public boolean closseConnection(Connection connection) {
        try {
            if (connection != null) {
                if (!connection.isClosed()) {
                    connection.close();
                }
            }
        } catch (Exception e) {
            System.err.println("Se ha producido un error cerrando la conecciton");
            return false;
        }
        return true;
    }


    public boolean deleteById(String sql) {
        Connection connection = null;
        try {
            connection = this.getConnection();
            PreparedStatement sentencia = connection.prepareStatement(sql);
            return sentencia.executeUpdate() > 0;
        } catch (Exception e) {
            System.err.println("No se han podido eliminar");
            return false;
        }
    }
}