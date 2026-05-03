package com.ejemplo.model;

public class Vehiculo {
    private Integer id;
    private String marca;
    private String modelo;
    private String tipo;
    private int disponible;

    public Vehiculo(Integer id, String marca, String modelo, String tipo, int disponible) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.tipo = tipo;
        this.disponible = disponible;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }
    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public int getDisponible() { return disponible; }
    public void setDisponible(int disponible) { this.disponible = disponible; }
    public boolean isDisponible() { return disponible == 1; }
}


// public class SQLiteConnectionManager {
//     private static final String URL = "jdbc:sqlite:src/main/resources/data/sqlite/fruteria.db";

//     public static Connection getConnection() throws SQLException {
//         Connection connection = DriverManager.getConnection(URL);
//         try (Statement statement = connection.createStatement()) {
//             statement.execute("PRAGMA foreign_keys = ON");
//         }
//         return connection;
//     }
// }