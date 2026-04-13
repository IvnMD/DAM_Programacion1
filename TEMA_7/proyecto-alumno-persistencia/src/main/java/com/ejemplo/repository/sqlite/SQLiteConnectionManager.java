package com.ejemplo.repository.sqlite;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class SQLiteConnectionManager {

    private String url;

    public SQLiteConnectionManager(String rutaDB) {
        try {
            File file = new File(rutaDB);
            if (!file.exists()) {
                Path path = Path.of(rutaDB);

                file.createNewFile();
                // inicializamos la BBDD
                Connection connection = connectionManager.getConnection();
            }
            this.url = rutaDB;
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        this.url = "jdbc:sqlite:" + rutaDB;
        // this.url = "jdbc:postgresql:" + rutaDB;
        // this.url = "jdbc:oracle;" + rutaDB;
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url);
    }
}
