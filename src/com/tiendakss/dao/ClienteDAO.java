package com.tiendakss.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.tiendakss.modelo.Cliente;

/**
 * Clase DAO para la entidad Cliente.
 * Retorna valores booleanos adaptados a las condiciones de negocio de la vista.
 */
public class ClienteDAO {

    private static final String INSERTAR_SQL = "INSERT INTO clientes (nombre, email, telefono) VALUES (?, ?, ?);";
    private static final String SELECCIONAR_TODOS = "SELECT * FROM clientes;";

    public boolean insertar(Cliente cliente) {
        try (Connection conexion = ConexionBD.obtenerConexion();
             PreparedStatement ps = conexion.prepareStatement(INSERTAR_SQL)) {
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getEmail());
            ps.setString(3, cliente.getTelefono());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Cliente> listar() {
        List<Cliente> lista = new ArrayList<>();
        try (Connection conexion = ConexionBD.obtenerConexion();
             PreparedStatement ps = conexion.prepareStatement(SELECCIONAR_TODOS);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                lista.add(new Cliente(
                    rs.getInt("id"), 
                    rs.getString("nombre"), 
                    rs.getString("email"), 
                    rs.getString("telefono"), 
                    null
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
}