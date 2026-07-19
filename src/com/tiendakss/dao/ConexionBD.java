package com.tiendakss.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
    // Definimos la ruta de la base de datos de tu Tienda KSS
    private static final String URL = "jdbc:mysql://localhost:3307/tienda_kss_db";
private static final String USER = "root";
private static final String PASSWORD = "";

    public static Connection obtenerConexion() throws SQLException {
        try {
            // Le indicamos a Java que use el conector que descargamos
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            throw new SQLException("Driver de MySQL no encontrado en la carpeta lib", e);
        }
    }
}