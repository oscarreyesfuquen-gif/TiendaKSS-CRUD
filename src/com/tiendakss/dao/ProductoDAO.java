package com.tiendakss.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.tiendakss.modelo.Producto;

/**
 * Clase DAO para la entidad Producto.
 * Retorna valores booleanos para cumplir con el flujo de control de la vista y servlets.
 */
public class ProductoDAO {

    private static final String INSERTAR_SQL = "INSERT INTO productos (nombre, precio, stock) VALUES (?, ?, ?);";
    private static final String SELECCIONAR_TODOS = "SELECT * FROM productos;";
    private static final String ACTUALIZAR_SQL = "UPDATE productos SET nombre = ?, precio = ?, stock = ? WHERE id = ?;";
    private static final String ELIMINAR_SQL = "DELETE FROM productos WHERE id = ?;";

    public boolean insertar(Producto producto) {
        try (Connection conexion = ConexionBD.obtenerConexion();
             PreparedStatement ps = conexion.prepareStatement(INSERTAR_SQL)) {
            ps.setString(1, producto.getNombre());
            ps.setDouble(2, producto.getPrecio());
            ps.setInt(3, producto.getStock());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Producto> listar() {
        List<Producto> lista = new ArrayList<>();
        try (Connection conexion = ConexionBD.obtenerConexion();
             PreparedStatement ps = conexion.prepareStatement(SELECCIONAR_TODOS);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                lista.add(new Producto(rs.getInt("id"), rs.getString("nombre"), rs.getDouble("precio"), rs.getInt("stock")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public boolean actualizar(Producto producto) {
        try (Connection conexion = ConexionBD.obtenerConexion();
             PreparedStatement ps = conexion.prepareStatement(ACTUALIZAR_SQL)) {
            ps.setString(1, producto.getNombre());
            ps.setDouble(2, producto.getPrecio());
            ps.setInt(3, producto.getStock());
            ps.setInt(4, producto.getId());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean eliminar(int id) {
        try (Connection conexion = ConexionBD.obtenerConexion();
             PreparedStatement ps = conexion.prepareStatement(ELIMINAR_SQL)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}