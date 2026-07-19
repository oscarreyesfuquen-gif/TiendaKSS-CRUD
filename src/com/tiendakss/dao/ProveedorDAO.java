package com.tiendakss.dao;

import com.tiendakss.modelo.Proveedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProveedorDAO {

    // 1. REGISTRAR UN NUEVO PROVEEDOR
    public boolean insertar(Proveedor proveedor) {
        String sql = "INSERT INTO proveedores (nit_rut, razon_social, contacto, telefono, direccion) VALUES (?, ?, ?, ?, ?)";
        
        try (Connection con = ConexionBD.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {
            
            ps.setString(1, proveedor.getNitRut());
            ps.setString(2, proveedor.getRazonSocial());
            ps.setString(3, proveedor.getContacto());
            ps.setString(4, proveedor.getTelefono());
            ps.setString(5, proveedor.getDireccion());
            
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al registrar proveedor: " + e.getMessage());
            return false;
        }
    }

    // 2. LISTAR TODOS LOS PROVEEDORES
    public List<Proveedor> listar() {
        List<Proveedor> lista = new ArrayList<>();
        String sql = "SELECT * FROM proveedores";
        
        try (Connection con = ConexionBD.obtenerConexion();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            
            while (rs.next()) {
                Proveedor p = new Proveedor();
                p.setIdProveedor(rs.getInt("id_proveedor"));
                p.setNitRut(rs.getString("nit_rut"));
                p.setRazonSocial(rs.getString("razon_social"));
                p.setContacto(rs.getString("contacto"));
                p.setTelefono(rs.getString("telefono"));
                p.setDireccion(rs.getString("direccion"));
                lista.add(p);
            }
        } catch (SQLException e) {
            System.out.println("Error al listar proveedores: " + e.getMessage());
        }
        return lista;
    }
}
