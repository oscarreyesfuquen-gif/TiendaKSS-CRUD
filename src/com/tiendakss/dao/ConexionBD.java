package com.tiendakss.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Clase encargada de gestionar la conexión con la base de datos MySQL.
 * Aplica el estándar JDBC para la persistencia de datos en la Tienda KSS.
 */
public class ConexionBD {
    
    // Parámetros de configuración de la base de datos local
    private static final String URL = "jdbc:mysql://localhost:3306/tienda_kss?useSSL=false&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "admin"; // Cambiar por tu contraseña local de MySQL si aplica
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";

    /**
     * Establece y retorna la conexión activa con MySQL.
     * @return Objeto Connection activo.
     */
    public static Connection obtenerConexion() {
        Connection conexion = null;
        try {
            // Carga el controlador JDBC de MySQL en memoria
            Class.forName(DRIVER);
            
            // Intenta establecer el puente de conexión con las credenciales
            conexion = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("CONEXIÓN EXITOSA: Conectado correctamente a la base de datos de Tienda KSS.");
            
        } catch (ClassNotFoundException e) {
            System.err.println("ERROR: No se encontró el Driver de MySQL en las librerías (lib).");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("ERROR de SQL: Fallo al conectar con los parámetros URL/Usuario/Password.");
            e.printStackTrace();
        }
        return conexion;
    }
}