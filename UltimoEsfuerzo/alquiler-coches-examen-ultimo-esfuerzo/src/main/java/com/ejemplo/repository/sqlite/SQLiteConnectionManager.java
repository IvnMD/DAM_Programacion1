package com.ejemplo.repository.sqlite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract  class SQLiteConnectionManager {
    public static String jdbcUrl = "jdbc:sqlite:target/alquiler-test.db";
    private SQLiteConnectionManager() {}
    public static Connection getConnection() throws SQLException { return DriverManager.getConnection(jdbcUrl); }
    public static void setJdbcUrl(String url) { jdbcUrl = url; }
    public static void setDatabasePath(String testDb) {
        jdbcUrl = "jdbc:sqlite:" + testDb;
    }
}
